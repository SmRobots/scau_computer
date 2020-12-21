import java.util.Scanner;

/**
 * 练习2：
 * 提示用户输入2个圆的圆心坐标和各自的半径值，判断并输出这两个圆之前的位置关系。
 * 圆的关系有：包含， 相交， 无关（相离）
 */
public class Exercise02 {
    public static void main(String[] args) {
        //创建两个圆对象
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Scanner input = new Scanner(System.in);
        //程序是否继续执行的标志，输入的第一个字符为q或者Q则退出程序的运行
        String keepRunning = " ";
        do {
            System.out.print("输入第一个圆x y r:");
            circle1.setX(input.nextDouble());
            circle1.setY(input.nextDouble());
            circle1.setRadius(input.nextDouble());

            System.out.print("输入第二个圆x y r:");
            circle2.setX(input.nextDouble());
            circle2.setY(input.nextDouble());
            circle2.setRadius(input.nextDouble());
            //获取两圆之间关系
            String relationShip = circle1.relationShip(circle2);
            switch (relationShip) {
                case "包含":
                    //包含关系中要判断是哪个圆包含哪个圆，根据半径判断即可
                    if (circle1.getRadius() > circle2.getRadius()) {
                        System.out.println(circle1 + "包含 " + circle2);
                    } else {
                        System.out.println(circle2 + "包含 " + circle1);
                    }
                    break;
                case "无关":
                    System.out.println("" + circle1 + "与 " + circle2 + "无关");
                    break;
                case "相交":
                    System.out.println("" + circle1 + "与 " + circle2 + "相交");
                    break;
                default:
                    break;
            }
            System.out.print("输入q/Q退出程序运行，键入其他字符程序继续运行：");
            keepRunning = input.next();
        }while(keepRunning.charAt(0) != 'q' && keepRunning.charAt(0) != 'Q');
    }

    /**
     * 创建一个圆类型，为了方便起见就在这个文件中定义一个内部类了
     */
    static class Circle {
        /**
         * 圆心的x轴坐标
         */
        private double x;
        /**
         * 圆心的y轴坐标
         */
        private double y;
        /**
         * 圆的半径
         */
        private double radius;

        /**
         * 判断两个圆之间的关系
         * @param circle
         * @return
         */
        public String relationShip(Circle circle) {
            if (distance(this.getX(), circle.getX(), this.getY(), circle.getY()) <
                    Math.abs(this.getRadius() - circle.getRadius())) {
                //包含：两圆圆心的距离大于半径的差值
                return "包含";
            } else if (distance(this.getX(), circle.getX(), this.getY(), circle.getY()) >
                    this.getRadius() + circle.getRadius()) {
                //无关：两圆圆心的距离大于半径之和
                return "无关";
            } else {
                return "相交";
            }
        }

        /**
         * 返回坐标（x1, y1）和坐标（x2, y2）两点之间的距离
         * @param x1
         * @param x2
         * @param y1
         * @param y2
         * @return
         */
        public static double distance(double x1, double x2, double y1, double y2) {
            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        /**
         * 重写toString,按照示例给的格式进行打印
         * @return
         */
        @Override
        public String toString() {
            return "(" +
                    x +
                    ", " + y +
                    ")-" + radius + " ";
        }
    }

}
