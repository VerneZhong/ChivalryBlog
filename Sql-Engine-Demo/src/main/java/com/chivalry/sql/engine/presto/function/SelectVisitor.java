package com.chivalry.sql.engine.presto.function;

import com.facebook.presto.sql.tree.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * support null, not null,in,>,>=,=,<,<=,+,-,*,/,between
 *
 * @author Mr.zxb
 * @date 2020-09-17 22:17:50
 */
public class SelectVisitor extends AstVisitor<Object, JSONContext> {

    public static boolean where(Expression exp, JSONContext context) {
        return (Boolean) new SelectVisitor().process(exp, context);
    }

    public static Object valueOf(Expression exp, JSONContext context) {
        return new SelectVisitor().process(exp, context);
    }

    @Override
    protected Object visitFunctionCall(FunctionCall node, JSONContext context) {
        Function function = SqlFunctionProxy.getFunction(node.getName().toString());
        if (function == null) {
            return null;
        }
        if (function.isProcessAll()) {
            context.done();
        }
        List<Object> args = new ArrayList<>();
        for (Expression argument : node.getArguments()) {
            args.add(this.process(argument, context));
        }
        return function.invoke(context, args.toArray());
    }

    @Override
    protected Object visitSimpleCaseExpression(SimpleCaseExpression node, JSONContext context) {
        Object caseOperand = this.process(node.getOperand(), context);
        for (WhenClause when : node.getWhenClauses()) {
            Object process = this.process(when.getOperand(), context);
            if (caseOperand.equals(process)) {
                return this.process(when.getResult(), context);
            }
        }
        if (node.getDefaultValue().isPresent()) {
            return this.process(node.getDefaultValue().get(), context);
        }
        return null;
    }

    @Override
    protected Object visitNotExpression(NotExpression node, JSONContext context) {
        Object process = this.process(node.getValue(), context);
        return !(Boolean) process;
    }

    @Override
    protected Object visitIsNotNullPredicate(IsNotNullPredicate node, JSONContext context) {
        Object expValue = this.process(node.getValue(), context);
        return expValue != null;
    }

    @Override
    protected Object visitIsNullPredicate(IsNullPredicate node, JSONContext context) {
        Object expValue = this.process(node.getValue(), context);
        return expValue == null;
    }

    @Override
    protected Object visitInPredicate(InPredicate node, JSONContext context) {
        Object value = this.process(node.getValue(), context);
        @SuppressWarnings("unchecked")
        ArrayList<Object> inList = (ArrayList<Object>) this.process(node.getValueList(), context);
        return inList.contains(value);
    }

    @Override
    protected Object visitInListExpression(InListExpression node, JSONContext context) {
        ArrayList<Object> inList = new ArrayList<Object>();
        for (Expression exp : node.getValues()) {
            inList.add(this.process(exp, context));
        }
        return inList;
    }

    @Override
    protected Object visitLogicalBinaryExpression(LogicalBinaryExpression node, JSONContext context) {
        Object left = this.process(node.getLeft(), context);
        Object right = this.process(node.getRight(), context);
        switch (node.getOperator()) {
            case AND:
                return (Boolean) left && (Boolean) right;
            case OR:
                return (Boolean) left || (Boolean) right;
            default:
                return null;
        }
    }

    @Override
    protected Object visitBetweenPredicate(BetweenPredicate node, JSONContext context) {
        Object value = this.process(node.getValue(), context);
        Object min = this.process(node.getMin(), context);
        Object max = this.process(node.getMax(), context);
        if (value instanceof Number) {
            return ((Number) value).doubleValue() >= ((Number) min).doubleValue()
                    && ((Number) value).doubleValue() <= ((Number) max).doubleValue();
        } else if (value instanceof String) {
            if (value.equals(min) || value.equals(max)) {
                return true;
            } else {
                return ((String) min).compareTo((String) value) < 0 && ((String) max).compareTo((String) value) > 0;
            }
        }
        return value.equals(min) || value.equals(max);
    }

    @Override
    protected Object visitComparisonExpression(ComparisonExpression node, JSONContext context) {
        Object left = this.process(node.getLeft(), context);
        Object right = this.process(node.getRight(), context);
        switch (node.getOperator()) {
            case EQUAL:
                return left.equals(right);
            case NOT_EQUAL:
                return !left.equals(right);
            case LESS_THAN:
                if (left instanceof Number) {
                    return ((Number) left).doubleValue() < ((Number) right).doubleValue();
                } else if (left instanceof String) {
                    return ((String) left).compareTo((String) right) < 0;
                }
                break;
            case LESS_THAN_OR_EQUAL:
                if (left instanceof Number) {
                    return ((Number) left).doubleValue() <= ((Number) right).doubleValue();
                } else if (left instanceof String) {
                    return ((String) left).compareTo((String) right) <= 0;
                }
                break;
            case GREATER_THAN:
                if (left instanceof Number) {
                    return ((Number) left).doubleValue() > ((Number) right).doubleValue();
                } else if (left instanceof String) {
                    return ((String) left).compareTo((String) right) > 0;
                }
                break;
            case GREATER_THAN_OR_EQUAL:
                if (left instanceof Number) {
                    return ((Number) left).doubleValue() >= ((Number) right).doubleValue();
                } else if (left instanceof String) {
                    return ((String) left).compareTo((String) right) >= 0;
                }
                break;
            default:
                // TODO LOG warn
        }
        return false;
    }

    @Override
    protected Object visitArithmeticUnary(ArithmeticUnaryExpression node, JSONContext context) {
        Object value = this.process(node.getValue(), context);
        switch (node.getSign()) {
            case PLUS:
                return value;
            case MINUS:
                if (value instanceof Long) {
                    return -((Long) value);
                } else {
                    return -((Double) value);
                }
            default:
                return null;
        }
    }

    @Override
    protected Object visitArithmeticBinary(ArithmeticBinaryExpression node, JSONContext context) {
        Object left = this.process(node.getLeft(), context);
        Object right = this.process(node.getRight(), context);
        switch (node.getOperator()) {
            case ADD:
                if (left instanceof Long) {
                    return ((Long) left) + ((Number) right).longValue();
                } else if (left instanceof Double) {
                    return ((Double) left) + ((Number) right).doubleValue();
                }else if(left instanceof String){
                    return (String)left+right;
                }
                break;
            case SUBTRACT:
                if (left instanceof Long) {
                    return ((Long) left) - ((Number) right).longValue();
                } else if (left instanceof Double) {
                    return ((Double) left) - ((Number) right).doubleValue();
                }
                break;
            case MULTIPLY:
                if (left instanceof Long) {
                    return ((Long) left) * ((Number) right).longValue();
                } else if (left instanceof Double) {
                    return ((Double) left) * ((Number) right).doubleValue();
                }
                break;
            case DIVIDE:
                if (left instanceof Long) {
                    return ((Long) left) / ((Number) right).longValue();
                } else if (left instanceof Double) {
                    return ((Double) left) / ((Number) right).doubleValue();
                }
                break;
            case MODULUS:
                if (left instanceof Long) {
                    return (Long) left % ((Number) right).longValue();
                }
                break;
            default:
                // LOG warn
        }
        return null;
    }

    @Override
    protected Object visitBooleanLiteral(BooleanLiteral node, JSONContext context) {
        return node.getValue();
    }

    @Override
    protected Object visitIdentifier(Identifier node, JSONContext context) {
        Object value = context.getRowJSON().get(node.getValue());
        // change default type of fastjson to
        if (value instanceof Number) {
            // presto-parser default type
            if (value instanceof Integer) {
                return ((Integer) value).longValue();
            } else if (value instanceof BigDecimal)
                return ((Number) value).doubleValue();
            else {
                return ((Number) value).longValue();
            }
        } else {
            return value;
        }
    }

    @Override
    protected Object visitLongLiteral(LongLiteral node, JSONContext context) {
        return node.getValue();
    }

    @Override
    protected Object visitDoubleLiteral(DoubleLiteral node, JSONContext context) {
        return node.getValue();
    }

    @Override
    protected Object visitDecimalLiteral(DecimalLiteral node, JSONContext context) {
        return Double.valueOf(node.getValue());
    }

    @Override
    protected Object visitStringLiteral(StringLiteral node, JSONContext context) {
        return node.getValue();
    }
}
