package com.spring.demo.license.verify;

import com.spring.demo.license.manager.CustomLicenseManager;
import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * @author sixiaojie
 * @date 2021-05-25-15:34
 */
public class LicenseManagerHolder {
    private static LicenseManager licenseManager;

    public static synchronized LicenseManager getInstance(LicenseParam licenseParam) {
        if(null == licenseManager) {
            try {
                licenseManager = new CustomLicenseManager(licenseParam);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return licenseManager;

    }
}
