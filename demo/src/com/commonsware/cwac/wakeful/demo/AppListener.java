/***
  Copyright (c) 2009-11 CommonsWare, LLC
  
  Licensed under the Apache License, Version 2.0 (the "License"); you may
  not use this file except in compliance with the License. You may obtain
  a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package com.commonsware.cwac.wakeful.demo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.SystemClock;
import com.commonsware.cwac.wakeful.WakefulIntentService;

public class AppListener implements WakefulIntentService.AlarmListener {
  public void scheduleAlarms(AlarmManager mgr, PendingIntent pi,
                             Context ctxt) {
	  //type
//	public   static   final   int  ELAPSED_REALTIME    
//	当系统进入睡眠状态时，这种类型的闹铃不会唤醒系统。直到系统下次被唤醒才传递它，该闹铃所用的时间是相对时间，是从系统启动后开始计时的,包括睡眠时 间，可以通过调用SystemClock.elapsedRealtime()获得。系统值是3    (0x00000003)。     
//	public   static   final   int  ELAPSED_REALTIME_WAKEUP    
//	能唤醒系统，用法同ELAPSED_REALTIME，系统值是2 (0x00000002) 。     
//	public   static   final   int  RTC    
//	当系统进入睡眠状态时，这种类型的闹铃不会唤醒系统。直到系统下次被唤醒才传递它，该闹铃所用的时间是绝对时间，所用时间是UTC时间，可以通过调用 System.currentTimeMillis()获得。系统值是1 (0x00000001) 。     
//	public   static   final   int  RTC_WAKEUP    
//	能唤醒系统，用法同RTC类型，系统值为 0 (0x00000000) 。     
//	Public static   final   int  POWER_OFF_WAKEUP    
//	能唤醒系统，它是一种关机闹铃，就是说设备在关机状态下也可以唤醒系统，所以我们把它称之为关机闹铃。使用方法同RTC类型，系统值为4(0x00000004)。     
    mgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            SystemClock.elapsedRealtime()+60000,
                            AlarmManager.INTERVAL_FIFTEEN_MINUTES, pi);
    
/* // 取消已经注册的与参数匹配的定时器     
    void   cancel(PendingIntent operation)    
    //注册一个新的延迟定时器  
    void   set(int type, long triggerAtTime, PendingIntent operation)    
    //注册一个重复类型的定时器  
    void   setRepeating(int type, long triggerAtTime, long interval, PendingIntent operation)    
    //注册一个非精密的重复类型定时器  
    void setInexactRepeating (int type, long triggerAtTime, long interval, PendingIntent operation)  
    //设置时区    
    void   setTimeZone(String timeZone)   */
  }

  public void sendWakefulWork(Context ctxt) {
    WakefulIntentService.sendWakefulWork(ctxt, AppService.class);
  }

  public long getMaxAge() {
    return(AlarmManager.INTERVAL_FIFTEEN_MINUTES*2);
  }
}
