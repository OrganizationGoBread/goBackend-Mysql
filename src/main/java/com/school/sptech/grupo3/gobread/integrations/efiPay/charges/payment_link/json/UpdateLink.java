package br.com.efi.charges.payment_link.json;

import java.util.HashMap;

import org.json.JSONObject;

import com.school.sptech.grupo3.gobread.integrations.efiPay.Credentials;
import br.com.efi.efisdk.EfiPay;
import br.com.efi.efisdk.exceptions.EfiPayException;

public class UpdateLink {
	public static void main(String[] args) {
		/* *********  Set credential parameters ******** */

		Credentials credentials = new Credentials();

		JSONObject options = new JSONObject();
		options.put("client_id", credentials.getClientId());
		options.put("client_secret", credentials.getClientSecret());
		options.put("sandbox", credentials.isSandbox());

		/* ************************************************* */ 

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", "0");
		
		JSONObject body = new JSONObject();
		body.put("billet_discount", 0);
		body.put("card_discount", 0);
		body.put("message", "link test");
		body.put("expire_at", "2022-12-12");
		body.put("request_delivery_address", false);
		body.put("payment_method", "all");

		try {
			EfiPay efi = new EfiPay(options);
			JSONObject response = efi.call("updateChargeLink", params, body);
			System.out.println(response);
		}catch (EfiPayException e){
			System.out.println(e.getCode());
			System.out.println(e.getError());
			System.out.println(e.getErrorDescription());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
