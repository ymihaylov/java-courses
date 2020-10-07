public class Main {
    public static void main(String[] args) {
        Computer.CPU cpu = new Computer.CPU(8, 650);
        Computer.MotherBoard motherBoard = new Computer.MotherBoard("ASUS X560UD", 400);
        Computer.HardDrive hardDrive = new Computer.HardDrive(2000, 300);

        Computer computer = new Computer(ComputerType.DESKTOP, cpu, motherBoard, hardDrive);
        System.out.println(computer.getTotalPrice());
    }
}
