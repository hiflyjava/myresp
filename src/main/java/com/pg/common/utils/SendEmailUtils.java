

package  com.pg.common.utils;
import com.pg.common.dto.in.MsgIn;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;
import java.io.*;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class SendEmailUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailUtils.class);

	public static void sendEmails(String fromEmail, String host, Integer port, String password, MsgIn msgIn) throws  Exception {

		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setUsername(fromEmail);
		javaMailSender.setPassword(password);
		javaMailSender.setHost(host);
		javaMailSender.setPort( port);
		javaMailSender.setDefaultEncoding("UTF-8");
		Properties props = new Properties();
		props.setProperty("mail.smtp.host",host);
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.connectiontimeout", "20000");
		props.setProperty("mail.smtp.timeout", "20000");
		javaMailSender.setJavaMailProperties(props);

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setTo(new String[]{msgIn.getEmail()});
		helper.setCc(fromEmail);
		helper.setFrom(fromEmail);
		helper.setSubject(msgIn.geteName());
		helper.setText(buildContent(msgIn), true);


//		String alarmIconName = "/static/123.jpg";
//		ClassPathResource img = new ClassPathResource(alarmIconName);
//		if (Objects.nonNull(img)) {
//			helper.addInline("icon-alarm", img);
//		}
		javaMailSender.send(message);
	}

	private static String buildContent(MsgIn msgIn) throws IOException {

		//加载邮件html模板

		// String fileName = "classpath:templates/index.html";


       ClassPathResource resource = new ClassPathResource("/static/pod-scale-alarm.html");
		InputStream inputStream = resource.getInputStream();

		InputStreamReader isr = new InputStreamReader(inputStream);

		BufferedReader fileReader = new BufferedReader(isr);
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = fileReader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			//LOGGER.error("读取文件失败，fileName:{}", fileName, e);
		} finally {
			fileReader.close();
		}


		//1
		String contentText = "以下是您入住本宾馆的信息, 敬请查看.<br>The following is your hotel information, please check. ";
		//邮件表格header
		//3
		String header = "<td>分区(Namespace)</td><td>服务(Service)</td><td>伸缩结果(Scale Result)</td><td>伸缩原因(Scale Reason)</td><td>当前实例数(Pod instance number)</td>";

		//4
		StringBuilder linesBuffer = new StringBuilder();
		linesBuffer.append("<tr><td>" + "myNamespace" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
				"<td>" + "mReason" + "</td><td>" + "my4" + "</td></tr>");

		//蓝色
		String emailHeadColor = "#4084d3";
		//2
		String date = DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss");
		//填充html模板中的五个参数
		String htmlText = MessageFormat.format(buffer.toString(), emailHeadColor, contentText, date, header,
				linesBuffer.toString(),msgIn.getGuestName(),msgIn.geteName(),msgIn.getKeyword(),msgIn.getRoomNbr(),msgIn.getStartTime(),msgIn.getEndTime(),msgIn.getAddress(),msgIn.getOrderNo(),msgIn.getNights());

		//改变表格样式
		htmlText = htmlText.replaceAll("<td>", "<td style=\"padding:6px 10px; line-height: 150%;\">");
		htmlText = htmlText.replaceAll("<tr>", "<tr style=\"border-bottom: 1px solid #eee; color:#666;\">");
		return htmlText;
	}


}
