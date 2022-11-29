//package my.foodon.blooddonationapp.Email;
//
//import android.content.Context;
//import android.os.AsyncTask;
//
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message.RecipientType;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class JavaMailApi extends AsyncTask<Void,Void,Void> {
//
//    private Context context;
//    private Session session;
//    private  String email, subject,massage;
//
//    public JavaMailApi(Context context, String email, String subject, String massage) {
//        this.context = context;
//        this.email = email;
//        this.subject = subject;
//        this.massage = massage;
//    }
//
//    @Override
//    protected Void doInBackground(Void... voids) {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host","smtp-gmail.com");
//        properties.put("mail.smtp.socketFactory.port","465");
//        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.port","465");
//
//        session = javax.mail.Session.getDefaultInstance(properties,new Authenticator(){
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return  new PasswordAuthentication(Util.EMAIL, Util.PASSWORD);
//
//            }
//
//        });
//
//        MimeMessage mimeMessage = new MimeMessage(session);
//        try {
//            mimeMessage.setFrom(new InternetAddress(Util.EMAIL));
//            mimeMessage.addRecipients(RecipientType.TO,String.valueOf(new InternetAddress(email)));
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//}
