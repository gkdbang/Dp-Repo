package com.quinnox.qtvt.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static final String MSG="Successfull";
	public static final String FAILURE="Fail";
	public static final String ResetPasswordUnsuccessful="Password change unSuccessfull";
	public static final String ResetPasswordsuccessful="Password change Successfull";
	public static final String NOTAUTHERIZED="NOTAUTHERIZED";
	public static final String croneTabBackupDirectory= "crontab -l > /opt/sterling/3M_stuff/passwordchange_masterbckup/cron_backups/";
	public static final String croneTabBackupFile ="crontab_backup_".concat(new SimpleDateFormat("'_'yyyyMMdd").format(new Date()))+".txt";
	public static final String Command = croneTabBackupDirectory+ croneTabBackupFile;
	public static final String removeCroneTabcommand="crontab -r";
	public static final String createCroneTab = "crontab /opt/sterling/3M_stuff/passwordchange_masterbckup/cron_backups/";
	public static final String createCroneTabCommand = croneTabBackupDirectory+ croneTabBackupFile;
	public static final String OPEN = "open";
	public static final String ONHOLD = "onhold";
	public static final String LAPSED = "lapsed";
	public static final String REJECTED = "rejected";
	public static final String ASSIGNED = "assigned";
	public static final String UTILIZED = "utilized";
	public static final int USER = 1;
	public static final int ADMIN = 2;
	public static final int SUPERADMIN = 3;
	public static final String NULLPOINTEREXCEPTION = "Null Pointer Exception";
	public static final String empCount="empcount";
	public static final String hourCount="hourcount";
	public static final String NO_COMMENTS="No Comment";
	
}