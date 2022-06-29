import java.util.Scanner;

class Taxi {
    String dest; // 목적지
    int dist; // 기본거리
    int destDist; // 목적지까지 거리
    int fare; // 기본요금
    int perFare; // 거리당 요금
    int taxiNum; //택시 번호
    int oil; // 주유량
    int speed; // 현재 속도
    String status; // 상태

    public Taxi(int taxiNum, String status, int oil, int speed, int dist, int destDist, int fare, int perFare, String dest) {
        this.taxiNum = taxiNum;
        this.status = status;
        this.oil = oil;
        this.speed = speed;
        this.dist = dist;
        this.destDist = destDist;
        this.fare = fare;
        this.perFare = perFare;
        this.dest =dest;
    }

    public void taxiStart() { // 운행시작
        System.out.println("택시번호는 " + taxiNum + "입니다.");
        if( oil >= 10 ){
            status = "일반";
            System.out.println("운행을 시작합니다.");
        } else {
            status = "운행 불가";
            System.out.println("주유량이 10 미만으로 운행이 불가능 합니다.");
        }
    }

    public void takeTaxi(){  //승객 탑승
        if(status.equals("일반")) {
            status = "운행 중";
            System.out.println("승객이 탑승했습니다.");
        }else {
            status = "탑승 불가";
            System.out.println("택시 탑승이 불가능합니다.");
        }

    }
    public void changeSpeed(){ // 속도 변경
        int chSpeed = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("현재 속도는 "+speed+"입니다. 변경할 속도를 입력해 주세요 speed :");
        chSpeed = sc.nextInt();
        speed = chSpeed;
        System.out.println("현재 속도는 "+speed+"입니다.");
    }
    public int add() { //거리당 요금 추가
        int add = 0; // 추가요금
        if(destDist>dist)
            add = (destDist - dist) * perFare;
        return add;
    }
    public void pay() { // 요금 결제
        int pay = 0;
        pay = add() + fare;
        System.out.println("최종요금은 "+pay+"원 입니다.");
    }



}
public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi(1234,"",15,30,30,15,5000,300,"스파르타");
        taxi.taxiStart();
        taxi.takeTaxi();
        if(taxi.status.equals("운행 중")) {
            taxi.changeSpeed();
            taxi.add();
            taxi.pay();
        }
    }
}
