package com.chivalry.design.patterns.visitor;

/**
 * 访问者实现
 * @author Mr.zxb
 * @date 2020-09-19 19:04:36
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public int visit(ItemElement element) {
        int cost = 0;
        // apply 5$ discount if book price is greater than 50
        if (element instanceof Book) {
            Book book = (Book) element;
            if (book.getPrice() > 50) {
                cost = book.getPrice() - 5;
            } else {
                cost = book.getPrice();
            }
            System.out.println("Book ISBN:: " + book.getIsbnNumber() + " cost = " + cost);
        }
        // fruit
        if (element instanceof Fruit) {
            Fruit fruit = (Fruit) element;
            cost = fruit.getPricePerKg() + fruit.getWeight();
            System.out.println(fruit.getName() + " cost = " + cost);
        }
        return cost;
    }
}
