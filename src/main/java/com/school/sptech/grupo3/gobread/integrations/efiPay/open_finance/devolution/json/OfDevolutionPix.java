package br.com.efi.open_finance.devolution.json;

import java.util.HashMap;

import org.json.JSONObject;

import com.school.sptech.grupo3.gobread.integrations.efiPay.Credentials;
import br.com.efi.efisdk.EfiPay;
import br.com.efi.efisdk.exceptions.EfiPayException;

public class OfDevolutionPix {
    public static void main(String[] args) {
		Credentials credentials = new Credentials();

		JSONObject options = new JSONObject();
		options.put("client_id", credentials.getClientId());
		options.put("client_secret", credentials.getClientSecret());
		options.put("certificate", credentials.getCertificate());
		options.put("sandbox", credentials.isSandbox());

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("identificadorPagamento", "urn:efi:316df855-b8f5-4bbb-ae65-c97d80549b6f");
		
		JSONObject body = new JSONObject();
        body.put("valor", "0.01");
	
		try {
			EfiPay efi = new EfiPay(options);
			JSONObject response = efi.call("ofDevolutionPix", params, body);
			System.out.println(response);
		}catch (EfiPayException e){
			System.out.println(e.getError());
			System.out.println(e.getErrorDescription());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
