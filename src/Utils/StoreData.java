package Utils;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import Métier.GestionnaireUser;


public class StoreData {
	public static void store() {
        Gson gson = new Gson();

        String employes = gson.toJson(GestionnaireUser.getAllUsers());
       

        ArrayList<String> jsonList = new ArrayList<String>();
        jsonList.add(employes);
       

        String fileName[] = {"users.json"};
        try {
            File dir = new File("./Data");
            dir.mkdir();
            for(int i =0;i<4;i++) {
                FileWriter file = new FileWriter("./Data/" + fileName[i]);
                file.write(jsonList.get(i));
                file.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
