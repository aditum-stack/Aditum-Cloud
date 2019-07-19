package com.ten.aditum.cloud.metric;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件报警工具
 */
public class EmailMetricUtil {

    /**
     * 发送邮件到163
     *
     * @param title 需要传输的标题
     * @param body  需要传输的内容
     */
    public static boolean sendMail163(String title, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", 465);

        props.put("username", "xxxx@163.com");
        props.put("password", "xxxx");
        props.put("to", "xxxx@163.com");

        return EmailMetricUtil.send(props, title, body);
    }

    /**
     * 发送邮件到gmail
     *
     * @param title 标题
     * @param body  内容
     */
    public static boolean sendMailGmail(String title, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        props.put("username", "xxxx@gmail.com");
        props.put("password", "xxxx");
        props.put("to", "xxxx@gmail.com");

        return EmailMetricUtil.send(props, title, body);
    }

    /**
     * 发送邮件到outlook
     *
     * @param title 标题
     * @param body  内容
     */
    public static boolean sendMailOutLook(String title, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.outlook.com");
        props.put("mail.smtp.port", "587");

        props.put("username", "xxxx@outlook.com");
        props.put("password", "xxxx");
        props.put("to", "xxxx@outlook.com");

        return EmailMetricUtil.send(props, title, body);
    }

    /**
     * 获取系统当前的时间
     * 以传入时间格式返回，传空返回默认格式
     *
     * @param format 时间格式
     */
    private static String getTitleTimeFormat(String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss/SSS";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * 发送邮件，获取参数，和标题还有内容
     *
     * @param props 参数
     * @param title 标题
     * @param body  内容
     */
    private static Boolean send(Properties props, String title, String body) {
        final String username = props.getProperty("username");
        final String password = props.getProperty("password");
        final String to = props.getProperty("to");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(title + "(" + EmailMetricUtil.getTitleTimeFormat(null) + ")");
            message.setContent(body, "text/html;charset=utf-8");

            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("发送完毕！");

        return true;
    }
}
