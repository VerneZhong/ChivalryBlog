package com.chivalry.design.patterns.builder;

/**
 * 电脑
 * @author Mr.zxb
 * @date 2020-09-19 21:01:55
 */
public class Computer {
    /**
     * required parameters
     */
    private String HDD;
    private String RAM;

    /**
     * optional parameters
     */
    private boolean isGraphicsCardEnabled; // 显卡是否开启
    private boolean isBluetoothEnabled; // 蓝牙是否开启

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }

    /**
     * Builder Class
     */
    static class ComputerBuilder {
        /**
         * required parameters
         */
        private String HDD;
        private String RAM;

        /**
         * optional parameters
         */
        private boolean isGraphicsCardEnabled; // 显卡是否开启
        private boolean isBluetoothEnabled; // 蓝牙是否开启

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            this.isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }
}
