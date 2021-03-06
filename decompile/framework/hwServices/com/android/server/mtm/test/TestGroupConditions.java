package com.android.server.mtm.test;

import android.os.Bundle;
import android.os.SystemClock;
import com.android.server.mtm.condition.GroupConditionMatchor;
import java.io.PrintWriter;

public final class TestGroupConditions {
    static GroupConditionMatchor testmatchor = GroupConditionMatchor.getInstance();

    public static final void test(PrintWriter pw, String[] args) {
        if (args[1] != null && pw != null) {
            if (args.length < 2) {
                pw.println("Bad command conditiontest:");
            }
            String cmd = args[1];
            GroupConditionMatchor groupConditionMatchor;
            if ("enable_log".equals(cmd)) {
                groupConditionMatchor = testmatchor;
                GroupConditionMatchor.enableDebug();
            } else if ("disable_log".equals(cmd)) {
                groupConditionMatchor = testmatchor;
                GroupConditionMatchor.disableDebug();
            } else if ("conditionMatch".equals(cmd)) {
                runConditionMatch(pw, args);
            } else {
                pw.println("Bad command :" + cmd);
            }
        }
    }

    private static void runConditionMatch(PrintWriter pw, String[] args) {
        if (args.length < 6) {
            pw.println("args is invalid");
            return;
        }
        int pid = Integer.parseInt(args[2]);
        int uid = Integer.parseInt(args[3]);
        int conditiontype = Integer.parseInt(args[4]);
        int conditionattribute = Integer.parseInt(args[5]);
        Bundle rsbundles = new Bundle();
        rsbundles.putInt("pid", pid);
        rsbundles.putInt("uid", uid);
        Bundle bundles = new Bundle();
        bundles.putBundle("resourcebundle", rsbundles);
        bundles.putInt("conditiontype", conditiontype);
        bundles.putInt("conditionattribute", conditionattribute);
        bundles.putString("conditionextend", "aaaaaaa");
        bundles.putString("combinedcondition", args[4]);
        long starttime = SystemClock.uptimeMillis();
        long durtime = SystemClock.uptimeMillis() - starttime;
        pw.println("test result is :" + testmatchor.conditionMatch(conditiontype, bundles) + "(0:UNMATCHED|1:MATCHED|2:FORBIDDEN)");
        pw.println("total time:" + durtime + "(ms)");
    }
}
