/*---------------------------------------------------------------------------------------------
FINEOS Corporation
FINEOS House, EastPoint Business Park,
Dublin 3, Ireland

(c) Copyright FINEOS Corporation.
ALL RIGHTS RESERVED

The software and information contained herein are proprietary to, and comprise valuable
trade secrets of, FINEOS Corporation, which intends to preserve as trade secrets such
software and information. This software should only be furnished subject to a written
license agreement and may only be used, copied, transmitted, and stored in accordance
with the terms of such license and with the inclusion of the above copyright notice.
If there is no written License Agreement between you and FINEOS Corporation, then you
have received this software in error and should be returned to FINEOS Corporation or
destroyed immediately, and you should also notify FINEOS Corporation. This software and
information or any other copies thereof may not be provided or otherwise made available
to any person who is not authorized to receive it pursuant to a written license Agreement
executed with FINEOS Corporation.
---------------------------------------------------------------------------------------------*/
package demo.proofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Entry class for Benefit Schedule component 
 * 
 * @author Copernicus Team
 * @since FAS-9527
 *
 */

@SpringBootApplication
public class PremiumCalculatorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PremiumCalculatorApplication.class);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(PremiumCalculatorApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}
}
