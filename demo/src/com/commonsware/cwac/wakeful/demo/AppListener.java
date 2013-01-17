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
//	��ϵͳ����˯��״̬ʱ���������͵����岻�ỽ��ϵͳ��ֱ��ϵͳ�´α����ѲŴ����������������õ�ʱ�������ʱ�䣬�Ǵ�ϵͳ������ʼ��ʱ��,����˯��ʱ �䣬����ͨ������SystemClock.elapsedRealtime()��á�ϵͳֵ��3    (0x00000003)��     
//	public   static   final   int  ELAPSED_REALTIME_WAKEUP    
//	�ܻ���ϵͳ���÷�ͬELAPSED_REALTIME��ϵͳֵ��2 (0x00000002) ��     
//	public   static   final   int  RTC    
//	��ϵͳ����˯��״̬ʱ���������͵����岻�ỽ��ϵͳ��ֱ��ϵͳ�´α����ѲŴ����������������õ�ʱ���Ǿ���ʱ�䣬����ʱ����UTCʱ�䣬����ͨ������ System.currentTimeMillis()��á�ϵͳֵ��1 (0x00000001) ��     
//	public   static   final   int  RTC_WAKEUP    
//	�ܻ���ϵͳ���÷�ͬRTC���ͣ�ϵͳֵΪ 0 (0x00000000) ��     
//	Public static   final   int  POWER_OFF_WAKEUP    
//	�ܻ���ϵͳ������һ�ֹػ����壬����˵�豸�ڹػ�״̬��Ҳ���Ի���ϵͳ���������ǰ�����֮Ϊ�ػ����塣ʹ�÷���ͬRTC���ͣ�ϵͳֵΪ4(0x00000004)��     
    mgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            SystemClock.elapsedRealtime()+60000,
                            AlarmManager.INTERVAL_FIFTEEN_MINUTES, pi);
    
/* // ȡ���Ѿ�ע��������ƥ��Ķ�ʱ��     
    void   cancel(PendingIntent operation)    
    //ע��һ���µ��ӳٶ�ʱ��  
    void   set(int type, long triggerAtTime, PendingIntent operation)    
    //ע��һ���ظ����͵Ķ�ʱ��  
    void   setRepeating(int type, long triggerAtTime, long interval, PendingIntent operation)    
    //ע��һ���Ǿ��ܵ��ظ����Ͷ�ʱ��  
    void setInexactRepeating (int type, long triggerAtTime, long interval, PendingIntent operation)  
    //����ʱ��    
    void   setTimeZone(String timeZone)   */
  }

  public void sendWakefulWork(Context ctxt) {
    WakefulIntentService.sendWakefulWork(ctxt, AppService.class);
  }

  public long getMaxAge() {
    return(AlarmManager.INTERVAL_FIFTEEN_MINUTES*2);
  }
}
