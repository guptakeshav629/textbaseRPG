import java.util.ArrayList;

public class Inventory {
    public static ArrayList<ArrayList<String>> weapon = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> potion = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> otherItem = new ArrayList<ArrayList<String>>();
    public static final int WEAPONID = 0;
    public static final int WEAPONNAME = 1;
    public static final int WEAPONTYPE = 2;
    public static final int WEAPONDAMAGE = 3;
    public static final int WEAPONCURRENTDURABILITY = 4;
    public static final int WEAPONDURABILITY = 5;
    public static final int WEAPONSPECIAL = 6;
    public static final int WEAPONSPECIALTYPE = 7;
    public static final int WEAPONDESCRIPTION = 8;
    public static final int WEAPONSTATE = 9;
    public static final int POTIONID = 0;
    public static final int POTIONNAME = 1;
    public static final int POTIONTYPE = 2;
    public static final int POTIONDHP = 3;
    public static final int POTIONMP = 4;
    public static final int POTIONDESCRIPTION = 5;
    public static final int POTIONQUANTITY = 6;
    public static final int OTHERITEMID = 0;
    public static final int OTHERITEMNAME = 1;
    public static final int OTHERITEMTYPE = 2;
    public static final int OTHERITEMQUANTITY = 3;

    //put item in the inventory
    public static void setInventoryItem (int itemID, int quantity){
        ArrayList<String> infoReceived = ItemGen.itemList.get(itemID);
        //adding weapon
        if (itemID >= 1000 && itemID < 2000){
            for (int i = 0; i < quantity; i++) {
               weapon.add(infoReceived);  
            }   
            }
        //adding armour
        else if (itemID >= 2000 && itemID < 3000){

        }
        //adding potion
        else if (itemID >= 3000 && itemID < 4000){
            for (int i = 0; i < quantity; i++) {
                if(!(potion.isEmpty())){
                    boolean hasSame = false;
                    int sameLocation = -1;
                    int a = 0;
                    while (hasSame == false && a < potion.size()){
                        ArrayList<String> copy = potion.get(a);
                        String original = infoReceived.get(POTIONID);
                        String copied = copy.get(POTIONID);
                        hasSame = original.equals(copied);
                        if (hasSame == true){
                            sameLocation = a;
                            break;
                        }
                        a++;
                    }    
                    if (hasSame == true){
                        ArrayList<String> copy = potion.get(sameLocation);
                        String k = copy.get(POTIONQUANTITY);
                        int j = Integer.parseInt(k);
                        j++;
                        copy.set(POTIONQUANTITY, Integer.toString(j));
                        potion.set(sameLocation, copy);
                    }
                    else if (hasSame == false){
                        potion.add(infoReceived);
                    }
                    else {
                        System.out.println("Error while stacking items.");
                    }
                    
                }
                else if (potion.isEmpty()){
                    potion.add(infoReceived);
                }
            }
        }
        //other items
        else if(itemID >= 4000 && itemID < 5000){
            for (int i = 0; i < quantity; i++) {
                if(!(otherItem.isEmpty())){
                    boolean hasSame = false;
                    int sameLocation = -1;
                    int a = 0;
                    while (hasSame == false && a < otherItem.size()){
                        ArrayList<String> copy = otherItem.get(a);
                        String original = infoReceived.get(OTHERITEMID);
                        String copied = copy.get(OTHERITEMID);
                        hasSame = original.equals(copied);
                        if (hasSame == true){
                            sameLocation = a;
                            break;
                        }
                        a++;
                    }    
                    if (hasSame == true){
                        ArrayList<String> copy = otherItem.get(sameLocation);
                        String k = copy.get(OTHERITEMQUANTITY);
                        int j = Integer.parseInt(k);
                        j++;
                        copy.set(OTHERITEMQUANTITY, Integer.toString(j));
                        otherItem.set(sameLocation, copy);
                    }
                    else if (hasSame == false){
                        otherItem.add(infoReceived);
                    }
                    else {
                        System.out.println("Error while stacking items.");
                    }
                    
                }
                else if (otherItem.isEmpty()){
                    otherItem.add(infoReceived);
                }
            } 
        }
        else {
            System.out.println("Item to inventory error");
        }
        
    }

    //returns boolean if the player has the item. Can be used for stackable items
    public static boolean haveItem(int ID){
        boolean haveItem = false;
        if(haveItemNum(ID) == -1){
            haveItem = false;
        }
        else if(haveItemNum(ID) != -1) {
            haveItem = true;
        }
        return haveItem;
    }

    //Search for the order number of item if it is present in the inventory
    //otherwise returns a value of -1
    //remember that this does not work for non-stackable items
    public static int haveItemNum(int ID){
        String iDString = Integer.toString(ID);
        int haveItemNum = -1;
        //for weapon
        if(ID >= 1000 && ID < 2000){
            for(int i = 0; i < weapon.size();i++){
                ArrayList<String> copy = weapon.get(i);
                String copiedID = copy.get(WEAPONID);
                if(copiedID.equals(iDString)){
                    haveItemNum = i;
                }
            }
            System.out.println("Error. Can't use haveItemNum method for non-stackable item");
        }
        //for armour
        else if(ID >= 2000 && ID < 3000){

        }
        //for potion
        else if(ID >= 3000 && ID < 4000){
            for(int i = 0; i < potion.size();i++){
                ArrayList<String> copy = potion.get(i);
                String copiedID = copy.get(POTIONID);
                if(copiedID.equals(iDString)){
                    haveItemNum = i;
                }
            }
        }
        else if(ID >= 4000 && ID < 5000){
            for(int i = 0; i < otherItem.size();i++){
                ArrayList<String> copy = otherItem.get(i);
                String copiedID = copy.get(OTHERITEMID);
                if(copiedID.equals(iDString)){
                    haveItemNum = i;
                }
            }
        }
        return haveItemNum;
    }

    //Current display of inventory
    public static void showInventory(){
        System.out.println("______________INVENTORY______________");
        System.out.println("");
        System.out.println("1. Weapons");
        System.out.println("");
        System.out.println("2. Armours");
        System.out.println("");
        System.out.println("3. Potions");
        System.out.println("");
        System.out.println("4. Other Items");
        System.out.println("");
        System.out.println("Type the number of category you want.");
        System.out.println("_____________________________________");
        int ans = Program.scanInt();
        System.out.println("");
        //chosing category
        switch (ans) {
            case 1:
                getWeapons();
                break;    
            case 2:
                
                break;
            case 3:
                getPotions();
                break;
            case 4:
                getOtherItem();
                break;
        
            default:
                break;
        }
        
    }

    //displaying weapons in inventory
    public static void getWeapons(){
        for (int i = 0; i < weapon.size(); i++){
        ArrayList<String> infoReceived = weapon.get(i);
        System.out.println(i + ". [" + infoReceived.get(WEAPONNAME) + "]");
        }
        System.out.println("");
        if (weapon.isEmpty()){
            System.out.println("You do not have any item in this category.");
        }
        else if (!(weapon.isEmpty())){
            System.out.println("Choose the number of the weapon you want to select.");
            int ans = Program.scanInt();
            System.out.println("");
            printSpecificWeapon(ans);
        }
    }

    //displaying potions in inventory
    public static void getPotions(){
        for (int i = 0; i < potion.size(); i++){
        ArrayList<String> infoReceived = potion.get(i);
        System.out.println(i + ". [" + infoReceived.get(POTIONNAME) + "] x" + infoReceived.get(POTIONQUANTITY));
        }
        System.out.println("");
        if (potion.isEmpty()){
            System.out.println("You do not have any item in this category.");
        }
        else if (!(potion.isEmpty())){
            System.out.println("Choose the number of the potion you want to select.");
            int ans = Program.scanInt();
            System.out.println("");
            printSpecificPotion(ans);
        }
    }
    //displaying potions in inventory
    public static void getOtherItem(){
        for (int i = 0; i < otherItem.size(); i++){
        ArrayList<String> infoReceived = otherItem.get(i);
        System.out.println(i + ". [" + infoReceived.get(OTHERITEMNAME) + "] x" + infoReceived.get(OTHERITEMQUANTITY));
        }
        System.out.println("");
        if (otherItem.isEmpty()){
            System.out.println("You do not have any item in this category.");
        }
        else if (!(otherItem.isEmpty())){
            System.out.println("Choose the number of the potion you want to select.");
            int ans = Program.scanInt();
            System.out.println("");
            printSpecificOtherItem(ans);
        }
    }
    //print specific weapon detail based on the order number in arraylist
    public static void printSpecificWeapon(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String weaponName = infoReceived.get(WEAPONNAME);
        String weaponType = infoReceived.get(WEAPONTYPE);
        String weaponDamage = infoReceived.get(WEAPONDAMAGE);
        String weaponCurrentDurability = infoReceived.get(WEAPONCURRENTDURABILITY);
        String weaponDurability = infoReceived.get(WEAPONDURABILITY);
        String weaponSpecial = infoReceived.get(WEAPONSPECIAL);
        String weaponSpecialType = infoReceived.get(WEAPONSPECIALTYPE);
        String weaponDescription = infoReceived.get(WEAPONDESCRIPTION);
        String weaponState = infoReceived.get(WEAPONSTATE);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + weaponName);
        System.out.println("Type:        " + weaponType);
        System.out.println("Damage:      " + weaponDamage);
        System.out.println("Durability:  " + weaponCurrentDurability + "/" +weaponDurability);
        System.out.println("Special:     " + weaponSpecialType +" +"+ weaponSpecial);
        System.out.println("Description: " + weaponDescription);
        System.out.println("State:       " + weaponState);
        System.out.println("_______________________________");
        System.out.println("");

    }
    //print specific potion detail based on the order number in arraylist
    public static void printSpecificPotion(int inventoryItemID){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String potionName = infoReceived.get(POTIONNAME);
        String potionType = infoReceived.get(POTIONTYPE);
        String potionHP = infoReceived.get(POTIONDHP);
        String potionMP = infoReceived.get(POTIONMP);
        String potionDescription = infoReceived.get(POTIONDESCRIPTION);
        String potionQuantity = infoReceived.get(POTIONQUANTITY);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + potionName);
        System.out.println("Type:        " + potionType);
        System.out.println("+ HP:        " + potionHP);
        System.out.println("+ MP:        " + potionMP);
        System.out.println("Description: " + potionDescription);
        System.out.println("Quantity:    " + potionQuantity);
        System.out.println("_______________________________");
        System.out.println("");

    }
    //print specific item detail based on the order number in arraylist
    public static void printSpecificOtherItem(int inventoryItemID){
        ArrayList<String> infoReceived = otherItem.get(inventoryItemID);
        String otherItemID = infoReceived.get(OTHERITEMID);
        String otherItemName = infoReceived.get(OTHERITEMNAME);
        String otherItemType = infoReceived.get(OTHERITEMTYPE);
        String otherItemQuantity = infoReceived.get(OTHERITEMQUANTITY);
        System.out.println("___________Item info___________");
        System.out.println("ID:          " + otherItemID);
        System.out.println("Name:        " + otherItemName);
        System.out.println("Type:        " + otherItemType);
        System.out.println("Quantity:    " + otherItemQuantity);
        System.out.println("_______________________________");
        System.out.println("");
    }
}
