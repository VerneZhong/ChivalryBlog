package com.chivalry.design.patterns;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // order_x_y_z x注文番号 y商品id，z为注文价格
        HashMap<String, Integer> orderMap = new HashMap<>();
        orderMap.put("order_000278_34_50", 2);
        orderMap.put("order_000483_48_320", 1);
        orderMap.put("order_000482_48_320", 1);
        orderMap.put("order_000973_68_70", 4);
        orderDetailPrint(orderMap);
    }

    public static void orderDetailPrint(HashMap<String, Integer> orderMap) {
        Map<String, Map<String, Integer>> orderInfo = new HashMap<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String[] orders = entry.getKey().split("_");
            String orderNumber = orders[1];
            String orderId = orders[2];
            String orderPrice = orders[3];
            Integer orderQuantity = entry.getValue();
            if (orderInfo.get(orderId) != null) {
                Map<String, Integer> order = orderInfo.get(orderId);
                order.put(orderPrice, order.get(orderPrice) + orderQuantity);
                orderInfo.put(orderId, order);
            } else {
                Map<String, Integer> order = new HashMap<>();
                order.put(orderPrice, orderQuantity);
                orderInfo.put(orderId, order);
            }
            count++;
            sb.append(orderNumber).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.printf("欢迎惠顾，您共下单%d次、单号分别为：%s", count, sb);
        System.out.println("\n订单汇总：");
        int num = 1;
        for (Map.Entry<String, Map<String, Integer>> entry : orderInfo.entrySet()) {
            Map<String, Integer> value = entry.getValue();
            for (String key : value.keySet()) {
                int totalPrice = Integer.parseInt(key) * value.get(key);
                System.out.printf("%d.商品id[%s] ：小计%d元（%d）個\n", num++, entry.getKey(), totalPrice, value.get(key));
            }
        }
    }
}
