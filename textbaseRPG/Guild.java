public class Guild {
    public static void guildPage(){
        //some code for receiving quest based on the part that the charater is in
        switch (Character.currentPart){
            case 1:
                Part1.quest1.questGen('F', "Get woods", 0, 50, "Get stones" , 0, 30, 100, 5, 2);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                break;
        }
        System.out.println();
        Program.waitingTime(4000);
    }
}
