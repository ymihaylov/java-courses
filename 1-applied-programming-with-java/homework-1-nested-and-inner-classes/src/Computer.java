public class Computer {
    private ComputerType type;

    private CPU cpu;
    private MotherBoard motherBoard;
    private HardDrive hardDrive;

    public Computer(ComputerType type, CPU cpu, MotherBoard motherBoard, HardDrive hardDrive) {
        this.type = type;
        this.cpu = cpu;
        this.motherBoard = motherBoard;
        this.hardDrive = hardDrive;
    }

    public double getTotalPrice() {
        return this.cpu.price + this.motherBoard.price + this.hardDrive.price;
    }

    static class CPU {
        private int cores;
        private double price;

        public CPU(int cores, double price) {
            this.cores = cores;
            this.price = price;
        }
    }

    static class MotherBoard {
        private String model;
        private double price;

        public MotherBoard(String model, double price) {
            this.model = model;
            this.price = price;
        }
    }

    static class HardDrive {
        private int capacity;
        private double price;

        public HardDrive(int capacity, double price) {
            this.capacity = capacity;
            this.price = price;
        }
    }
}
