package cs112.ud2;

public class TestMain {



    public static void main(String[] args) {
        //TESTING BAG
        StandBag flextech1 = null;
        try{
             flextech1 = new StandBag("N00000",2020,"FLXTCHBLK",
                    "m1086","2036","m1118","m1431","2546","1899",
                    true,true,true);
        } catch (InvalidSkuException ise){
            System.out.println(ise.getMessage());
        } catch(InvalidThreadCodeException itce){
            System.out.println(itce.getMessage());

        } catch(InvalidYearException iye){
            System.out.println(iye.getMessage());
        }

        if (flextech1 != null) {
            System.out.println(flextech1.toString());
        } else {
            System.out.println("StandBag object not created due to instantiation error. Check above exceptions");
        }

        //CHECK ERROR HANDLING
        /*
        try{
            flextech1.setAll("N00000sda",4000,"FLXTCHBLK",
                    "m1086","2036","m1118adsd","m1431","2546","1899",
                    true,true,true);
        }catch (InvalidSkuException ise){
            System.out.println(ise.getMessage());
        } catch(InvalidThreadCodeException itce){
            System.out.println(itce.getMessage());

        } catch(InvalidYearException iye){
            System.out.println(iye.getMessage());
        }
        System.out.println(flextech1.toString());

         */
        //TESTING SETALL
        try{
            flextech1.setAll("N00000",2018,"FLXTCHBLK",
                    "1234","1234","1234","1234","1234","1234",
                    true,true,true);
        }catch (InvalidSkuException ise){
            System.out.println(ise.getMessage());
        } catch(InvalidThreadCodeException itce){
            System.out.println(itce.getMessage());

        } catch(InvalidYearException iye){
            System.out.println(iye.getMessage());
        }
        System.out.println(flextech1.toString());




        //TESTING HAT
        Hat snapback1 = null;

        try{
            snapback1 = new Hat("N00000",2018,"FLXTCHBLK",
                    "1234","1234","1234fff","1234","1234","1234",
                    true,true,true,false);
        }catch (InvalidSkuException ise){
            System.out.println(ise.getMessage());
        } catch(InvalidThreadCodeException itce){
            System.out.println(itce.getMessage());
        } catch(InvalidYearException iye){
            System.out.println(iye.getMessage());
        }

        if (snapback1 != null) {
            System.out.println(snapback1.toString());
        } else {
            System.out.println("StandBag object not created due to instantiation error. Check above exceptions");
        }

    }
}
