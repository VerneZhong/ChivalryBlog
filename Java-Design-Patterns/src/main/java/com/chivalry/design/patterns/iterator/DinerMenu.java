package com.chivalry.design.patterns.iterator;

/**
 * 晚餐菜单
 * @author Mr.zxb
 * @date 2020-08-30 21:26:39
 */
public class DinerMenu {
    public static final int MAX_ITEMS = 4;
    private int numberOfItems = 0;
    private final MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT", "全麦培根莴苣和番茄", true, 2.99);
        addItem("BLT", "培根配生菜和番茄全麦", false, 2.99);
        addItem("当天的汤", "当天的汤，配以土豆沙拉", false, 3.29);
        addItem("热狗", "热狗, 配酸菜，调味，洋葱，加奶酪", false, 3.99);
    }

    /**
     * 新增菜单
     * @param name
     * @param description
     * @param vegetarian
     * @param price
     */
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    /**
     * 返回菜单列表
     * @return
     */
    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    /**
     * 返回一个迭代器的实现
     * @return
     */
    public Iterator createIterator() {
        return new DinerMenuIterator(getMenuItems());
    }
}
