import java.util.*;

class Algo2{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0; i<t; i++){

            int houses = sc.nextInt();

            double totalHours = 0;
            double accentQty = 0;
            double regularQty = 0;
            
            for(int j=0; j<houses; j++){
                int victorianStyleHalls = sc.nextInt();
                int standerdRooms = sc.nextInt();
                int roofBedRooms = sc.nextInt();
                int kitchenRooms = sc.nextInt();

                //approach to solve question

                // for victorian style halls
                accentQty += ((victorianStyleHalls*6)/3)*1.5;
                totalHours += ((victorianStyleHalls*6)/3)*2.5;
                regularQty += ((victorianStyleHalls*6*2)/3)*2.25;
                totalHours += ((victorianStyleHalls*6*2)/3)*3.25;

                // for standard rooms
                accentQty += ((standerdRooms*4)/3)*1.5;
                totalHours += ((standerdRooms*4)/3)*2.5;
                regularQty += ((standerdRooms*4*2)/3)*2.25;
                totalHours += ((standerdRooms*4*2)/3)*3.25;

                //for roof bed rooms
                accentQty += ((roofBedRooms*3)/3)*1.5;
                totalHours += ((roofBedRooms*3)/3)*2.5;
                regularQty += ((roofBedRooms*3*2)/3)*2.25;
                totalHours += ((roofBedRooms*3*2)/3)*3.25;

                // for kitchen rooms
                accentQty += ((kitchenRooms*4)/3)*1.5;
                totalHours += ((kitchenRooms*4)/3)*2.5;
                regularQty += ((kitchenRooms*4*2)/3)*2.25;
                totalHours += ((kitchenRooms*4*2)/3)*3.25;
                
            }
            System.out.println(totalHours+" "+accentQty+" "+regularQty);
        }

    }
}