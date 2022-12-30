package test.java;

import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.JvmUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    GroupAdmin admin0 = new GroupAdmin();
    ConcreteMember m1 = new ConcreteMember();
    ConcreteMember m2 = new ConcreteMember();
    ConcreteMember m3 = new ConcreteMember();
    ConcreteMember m4 = new ConcreteMember();
    ConcreteMember m5 = new ConcreteMember();
    ConcreteMember m6 = new ConcreteMember();

    /**
     * a shallow copy of the Test class
     */
    public Tests() {
    }
    @Test
    public void testClientsObserver() {
        admin0.register(m1);
        admin0.register(m2);
        admin0.register(m3);
        admin0.register(m4);
        admin0.register(m5);
        admin0.register(m6);

        admin0.append("String");
        this.m1.toString().equals("String");
        this.m2.toString().equals("String");
        this.m3.toString().equals("String");
        this.m4.toString().equals("String");
        this.m5.toString().equals("String");
        this.m6.toString().equals("String");


        admin0.delete(0, 2);
        this.m1.toString().equals("ring");
        this.m2.toString().equals("ring");
        this.m3.toString().equals("ring");
        this.m4.toString().equals("ring");
        this.m5.toString().equals("ring");
        this.m6.toString().equals("ring");


        admin0.append(" ring");
        this.m1.toString().equals("ring ring");
        this.m2.toString().equals("ring ring");
        this.m3.toString().equals("ring ring");
        this.m4.toString().equals("ring ring");
        this.m5.toString().equals("ring ring");
        this.m6.toString().equals("ring ring");


        admin0.undo();
        this.m1.toString().equals("ring");
        this.m2.toString().equals("ring");
        this.m3.toString().equals("ring");
        this.m4.toString().equals("ring");
        this.m5.toString().equals("ring");
        this.m6.toString().equals("ring");

    }

    @Test
    public void checkingTheSize() {

        String s1 = "Alice";
        String s2 = "Bob";
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size without registered members as clients " + JvmUtilities.objectTotalSize(var10000);});
        admin0.register(this.m1);
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size with one registered members as clients " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.register(this.m2);
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size with two registered members as clients " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.register(this.m3);
        logger.info(() -> {
            Object[] var10000 = new Object[]{this.admin0};
            return "Group admin size with three registered members as clients " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.register(this.m4);
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size with four registered members as clients " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.register(this.m5);
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size with five registered members as clients " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.register(this.m6);
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size with four registered members as client" + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.append("ABC");
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size after appending a String " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.delete(0,2);
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size after deleting 2 chars " + JvmUtilities.objectTotalSize(var10000);
        });
        admin0.undo();
        logger.info(() -> {
            Object[] var10000 = new Object[]{admin0};
            return "Group admin size after undoing previous order " + JvmUtilities.objectTotalSize(var10000);
        });

        logger.info(()-> JvmUtilities.objectFootprint(s1));

        logger.info(()-> JvmUtilities.objectFootprint(s1,s2));

        logger.info(()-> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
