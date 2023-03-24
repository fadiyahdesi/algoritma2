import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TugasMandiri2D {
    public static void main(String[] args) throws IOException {
        TugasMandiri1 koneksisaya = new TugasMandiri1();
        URL MyAdress = koneksisaya.buildURL
                ( "https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = TugasMandiri1.getresponseFromHttpUrl(MyAdress);
        System.out.println(response);

        //decoding json
        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<TugasMandiriii> ResponseModel = new ArrayList<>();
        for (int i=0; i<responseJSON.length(); i++){
            TugasMandiriii resModel = new TugasMandiriii();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setI_code(myJSONObject.getString("i_code"));
            resModel.set0_code(myJSONObject.getString("g_code"));
            resModel.setI_supp(myJSONObject.getString("i_supp"));
            resModel.setI_barcode(myJSONObject.getString("i_barcode"));
            resModel.setI_nama(myJSONObject.getString("i_nama"));
            resModel.setI_sell(myJSONObject.getString("i_sell"));
            resModel.setI_kyt(myJSONObject.getString("i_kyt"));
        }
        System.out.println("Response Are: ");
        for(int index = 0; index<ResponseModel.size();index++){
            int hargajual = Integer.parseInt(ResponseModel.get(index).getI_sell());
            if (ResponseModel.get(index).getI_nama().contains("S")&& hargajual < 7000 ){
                System.out.println("Nama Barang : " + ResponseModel.get(index).getI_NamaBarang());
                System.out.println("Harga Barang : " + ResponseModel.get(index).getI_sell());
            }
        }
    }
}
