//package org.serratec.backend.projeto08.borracharia.services;
//
//import javax.mail.internet.MimeMessage;
//
//import org.serratec.backend.projeto08.borracharia.dto.ServicoDTO;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//@Configuration
//public class EmailConfig {
//
//	
//	private final JavaMailSender mailSender;
//	
//	
//	
//	public EmailConfig(JavaMailSender mailSender) {
//		super();
//		this.mailSender = mailSender;
//	}
//
//
//
//	public void enviar(ServicoDTO servicoDTO) throws Exception {
//		
//		StringBuilder sBuilder = new StringBuilder();
//
//sBuilder.append("<html>");
//sBuilder.append("<body>");
//sBuilder.append(    "<div style=\"font-weight: 400; color: blue\">");
//sBuilder.append(       "<center>");
//sBuilder.append(           "<h1>Olá, " + servicoDTO.getStatus()  + "</h1>");
//sBuilder.append(       "</center>");
//sBuilder.append(       "<center>");
//sBuilder.append(           "<p style=\"text-align: justify\">Seu certificado digital emitido junto à CDL de Nova Friburgo está perto de expirar.</p>");                                
//sBuilder.append(           "<p style=\"text-align: justify\">Para emitir seu novo certificado é muito simples: basta preencher um dos formulários que enviamos anexos, conforme sua necessidade (pessoa física ou jurídica), e ele será automaticamente devolvido para nosso e-mail. </p>");
//sBuilder.append(           "<p style=\"text-align: justify\">Em seguida, por favor, entre em contato conosco, para marcar data e horário para a certificação. Nosso telefone é (22) 2525-2029.</p>");                                
//sBuilder.append(           "<p style=\"text-align: justify\">Nos formulários, estão especificados os documentos necessários à emissão: não deixe de providenciá-los para evitar atraso na liberação do seu documento! Também oferecemos a opção de certificação online, que dispensa comparecimento à nossa sede.</p>");
//sBuilder.append(           "<p style=\"text-align: justify\">Se preferir a emissão presencial, o posto da CDL de Nova Friburgo fica à Rua Fernando Bizzotto, 39 – Centro. Lembramos que nosso agendamento é rápido, seguro e confiável. O atendimento acontece de segunda a sexta-feira das 8h às 18h e nos sábados das 8h às 12h.</p>");
//sBuilder.append(           "<p style=\"text-align: justify\">Os certificados digitais emitidos na CDL de Nova Friburgo têm validade jurídica, excelentes preços e a marca de confiança da nossa entidade. Empresas associadas e contabilidades ainda ganham desconto especial sobre os valores de tabela.</p>");
//sBuilder.append(           "<p>Segue o link para os formulários: http://localhost:3000/formularios </p>");
//sBuilder.append(           "<p>Não deseja mais receber esse tipo de email ? http://localhost:3000/descadastro </p><br>");
//sBuilder.append(       "</center>");
//sBuilder.append(       "<center style=\"opacity: 0.4\">");
//sBuilder.append(          "<img src='http://www.cdlnf.com.br/2017/wp-content/themes/cdl/images/g852.png' alt='logo cdl'>");
//sBuilder.append(       "</center>");
//sBuilder.append(        "<div>");
//sBuilder.append(           "<p>Atenciosamente,</p> <br>");
//sBuilder.append(           "<p><em>Equipe CDL</em> <br>");
//sBuilder.append(           "<p><strong>Certificação Digital</strong><br>");
//sBuilder.append(           "<p><strong>AR CDL Nova Friburgo</strong> </p>");
//sBuilder.append(        "</div>");
//sBuilder.append(        "<center>");
//sBuilder.append("<p>E-mail automático. Caso já tenha respondido este email e enviado o seu formulário favor desconsiderar essa mensagem.</p>");
//sBuilder.append(        "</center>");
//sBuilder.append(    "</div>");
//sBuilder.append(    "</body>");
//sBuilder.append("</html>");
//sBuilder.append("");
//		
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//		helper.setFrom("novafriburgo.cdl@gmail.com");
//		helper.setSubject("Charles Rodas e Pneus");			
//		helper.setText(sBuilder.toString(), true);	
//		helper.setTo("patrick.fischer@aluno.senai.br");
//		try {
//			mailSender.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//	}
//}