package com.spring.demo.license.utils;

import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.spring.demo.license.info.AbstractServerInfos;
import com.spring.demo.license.info.LinuxServerInfos;
import com.spring.demo.license.info.MacOsServerInfos;
import com.spring.demo.license.info.WindowsServerInfos;
import com.spring.demo.license.model.LicenseCheckModel;

public class MessageUtil {
    public static LicenseCheckModel getMessage() {
        AbstractServerInfos abstractServerInfo;

        //根据不同操作系统类型选择不同的数据获取方法
        OsInfo osInfo = SystemUtil.getOsInfo();
        if (osInfo.isWindows()) {
            abstractServerInfo = new WindowsServerInfos();
        } else if (osInfo.isMac()) {
            abstractServerInfo = new MacOsServerInfos();
        }else{//其他服务器类型
            abstractServerInfo = new LinuxServerInfos();
        }

        return abstractServerInfo.generateMes();
    }
}
