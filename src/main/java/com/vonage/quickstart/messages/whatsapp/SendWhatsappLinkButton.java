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
package com.vonage.quickstart.messages.whatsapp;

import com.vonage.client.VonageClient;
import com.vonage.client.messages.whatsapp.Locale;
import com.vonage.client.messages.whatsapp.Policy;
import com.vonage.client.messages.whatsapp.WhatsappCustomRequest;
import static com.vonage.quickstart.EnvironmentVariables.*;
import java.util.List;
import java.util.Map;

public class SendWhatsappLinkButton {
    public static void main(String[] args) throws Exception {
		VonageClient client = VonageClient.builder()
				.applicationId(VONAGE_APPLICATION_ID)
				.privateKeyPath(VONAGE_PRIVATE_KEY_PATH)
				.build();

		var response = client.getMessagesClient().sendMessage(
			WhatsappCustomRequest.builder()
				.from(WHATSAPP_SENDER_ID).to(MESSAGES_TO_NUMBER)
				.custom(Map.of(
					"type", "template",
					"template", Map.of(
						"namespace", WHATSAPP_TEMPLATE_NAMESPACE,
						"name", WHATSAPP_TEMPLATE_NAME,
						"language", Map.of(
							"code", Locale.ENGLISH,
							"policy", Policy.DETERMINISTIC
						),
						"components", List.of(
							Map.of(
								"type", "header",
								"parameters", List.of(
									Map.of(
										"type", "image",
										"image", Map.of(
											"link", WHATSAPP_HEADER_IMAGE_URL
										)
									)
								)
							),
							Map.of(
								"type", "body",
								"parameters", List.of(
									Map.of(
										"type", "text",
										"text", "Anand"
									),
									Map.of(
										"type", "text",
										"text", "Quest"
									),
									Map.of(
										"type", "text",
										"text", "113-0921387"
									),
									Map.of(
										"type", "text",
										"text", "23rd Nov 2019"
									)
								)
							),
							Map.of(
								"type", "button",
								"index", "0",
								"sub_type", "url",
								"parameters", List.of(
									Map.of(
										"type", "text",
										"text", "1Z999AA10123456784"
									)
								)
							)
						)
					)
				))
				.build()
		);
		System.out.println("Message sent successfully. ID: "+response.getMessageUuid());
	}
}
