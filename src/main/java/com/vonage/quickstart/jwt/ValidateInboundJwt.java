/*
 * Copyright  2025 Vonage
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
package com.vonage.quickstart.jwt;

import com.vonage.jwt.Jwt;
import spark.Route;
import spark.Spark;
import static com.vonage.quickstart.EnvironmentVariables.*;

public class ValidateInboundJwt {
    public static void main(String[] args) throws Exception {

        Route validateJwt = (req, res) -> {
            String token = req.headers("Authorization").substring(7);

            if (Jwt.verifySignature(token, VONAGE_SIGNATURE_SECRET)) {
                res.status(204);
            }
            else {
                res.status(401);
            }

            return "";
        };
        Spark.port(5000);
        Spark.post("/webhooks/validatejwt", validateJwt);
    }
}
