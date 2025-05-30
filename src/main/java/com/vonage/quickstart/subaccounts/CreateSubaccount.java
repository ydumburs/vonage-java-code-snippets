/*
 * Copyright 2025 Vonage
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.vonage.quickstart.subaccounts;

import com.vonage.client.VonageClient;
import com.vonage.client.subaccounts.Account;
import com.vonage.client.subaccounts.CreateSubaccountRequest;
import static com.vonage.quickstart.EnvironmentVariables.*;

public class CreateSubaccount {
    public static void main(String[] args) throws Exception {
		
		VonageClient client = VonageClient.builder()
				.apiKey(VONAGE_API_KEY)
				.apiSecret(VONAGE_API_SECRET)
				.build();

		Account subaccount = client.getSubaccountsClient().createSubaccount(
				CreateSubaccountRequest.builder()
					.name(SUBACCOUNT_NAME)
					.secret(SUBACCOUNT_SECRET)
					.build()
		);
	}
}
