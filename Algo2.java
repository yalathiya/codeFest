import java.util.*;

class Algo2{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();
        for(int i=0; i<t; i++){

            int houses = sc.nextInt();

            double th = 0;
            double aq = 0;
            double rq = 0;
            double walls = 0;

            for(int j=0; j<houses; j++){
                int victorianStyleHalls = sc.nextInt();
                int standerdRooms = sc.nextInt();
                int roofBedRooms = sc.nextInt();
                int kitchenRooms = sc.nextInt();

                walls += (victorianStyleHalls*6)+(standerdRooms*4)+(roofBedRooms*4)+(4);
                
                
                
            }
            aq = aq +walls*(1.0/3.0)*1.5;
            rq = rq +walls*(2.0/3.0)*2.25;
            th = th+(walls*(1.0/3.0)*2.5) + (walls*(2.0/3.0)*3.25);
            System.out.println("Number of total walls"+ walls);
            System.out.println(th+" "+aq+" "+rq);
        }

    }
}