package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n");
      out.write("                <form action=\"create\" method=\"POST\">\n");
      out.write("                    <div class=\"modal-dialog\">\n");
      out.write("                        <!-- Modal content-->\n");
      out.write("                        <div class=\"modal-content\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                <h4 class=\"modal-title\">Sign Up</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\n");
      out.write("                                <h5>Roll Number:</h5>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"usr\" placeholder=\"Roll Number\">\n");
      out.write("                                <h5>Password:</h5>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"pwd\" placeholder=\"Password\">\n");
      out.write("                                <input type=\"text\" class =\"form-control\" name=\"firstName\" placeholder=\"Your First Name\">\n");
      out.write("                                <input type=\"text\" class =\"form-control\" name=\"middleName\" placeholder=\"Your Middle Name\">\n");
      out.write("                                <input type=\"text\" class =\"form-control\" name=\"lastName\" placeholder=\"Your Last Name\">\n");
      out.write("                                <input type=\"date\" class =\"form-control\" name=\"dateOfBirth\">\n");
      out.write("                                <h5>Country:</h5>\n");
      out.write("                                <select class=\"form-control\" name=\"country\">\n");
      out.write("                                    <option value=\"Afghanistan\">Afghanistan</option>\n");
      out.write("                                    <option value=\"Albania\">Albania</option>\n");
      out.write("                                    <option value=\"Algeria\">Algeria</option>\n");
      out.write("                                    <option value=\"American Samoa\">American Samoa</option>\n");
      out.write("                                    <option value=\"Andorra\">Andorra</option>\n");
      out.write("                                    <option value=\"Angola\">Angola</option>\n");
      out.write("                                    <option value=\"Anguilla\">Anguilla</option>\n");
      out.write("                                    <option value=\"Antartica\">Antarctica</option>\n");
      out.write("                                    <option value=\"Antigua and Barbuda\">Antigua and Barbuda</option>\n");
      out.write("                                    <option value=\"Argentina\">Argentina</option>\n");
      out.write("                                    <option value=\"Armenia\">Armenia</option>\n");
      out.write("                                    <option value=\"Aruba\">Aruba</option>\n");
      out.write("                                    <option value=\"Australia\">Australia</option>\n");
      out.write("                                    <option value=\"Austria\">Austria</option>\n");
      out.write("                                    <option value=\"Azerbaijan\">Azerbaijan</option>\n");
      out.write("                                    <option value=\"Bahamas\">Bahamas</option>\n");
      out.write("                                    <option value=\"Bahrain\">Bahrain</option>\n");
      out.write("                                    <option value=\"Bangladesh\">Bangladesh</option>\n");
      out.write("                                    <option value=\"Barbados\">Barbados</option>\n");
      out.write("                                    <option value=\"Belarus\">Belarus</option>\n");
      out.write("                                    <option value=\"Belgium\">Belgium</option>\n");
      out.write("                                    <option value=\"Belize\">Belize</option>\n");
      out.write("                                    <option value=\"Benin\">Benin</option>\n");
      out.write("                                    <option value=\"Bermuda\">Bermuda</option>\n");
      out.write("                                    <option value=\"Bhutan\">Bhutan</option>\n");
      out.write("                                    <option value=\"Bolivia\">Bolivia</option>\n");
      out.write("                                    <option value=\"Bosnia and Herzegowina\">Bosnia and Herzegowina</option>\n");
      out.write("                                    <option value=\"Botswana\">Botswana</option>\n");
      out.write("                                    <option value=\"Bouvet Island\">Bouvet Island</option>\n");
      out.write("                                    <option value=\"Brazil\">Brazil</option>\n");
      out.write("                                    <option value=\"British Indian Ocean Territory\">British Indian Ocean Territory</option>\n");
      out.write("                                    <option value=\"Brunei Darussalam\">Brunei Darussalam</option>\n");
      out.write("                                    <option value=\"Bulgaria\">Bulgaria</option>\n");
      out.write("                                    <option value=\"Burkina Faso\">Burkina Faso</option>\n");
      out.write("                                    <option value=\"Burundi\">Burundi</option>\n");
      out.write("                                    <option value=\"Cambodia\">Cambodia</option>\n");
      out.write("                                    <option value=\"Cameroon\">Cameroon</option>\n");
      out.write("                                    <option value=\"Canada\">Canada</option>\n");
      out.write("                                    <option value=\"Cape Verde\">Cape Verde</option>\n");
      out.write("                                    <option value=\"Cayman Islands\">Cayman Islands</option>\n");
      out.write("                                    <option value=\"Central African Republic\">Central African Republic</option>\n");
      out.write("                                    <option value=\"Chad\">Chad</option>\n");
      out.write("                                    <option value=\"Chile\">Chile</option>\n");
      out.write("                                    <option value=\"China\">China</option>\n");
      out.write("                                    <option value=\"Christmas Island\">Christmas Island</option>\n");
      out.write("                                    <option value=\"Cocos Islands\">Cocos (Keeling) Islands</option>\n");
      out.write("                                    <option value=\"Colombia\">Colombia</option>\n");
      out.write("                                    <option value=\"Comoros\">Comoros</option>\n");
      out.write("                                    <option value=\"Congo\">Congo</option>\n");
      out.write("                                    <option value=\"Congo\">Congo, the Democratic Republic of the</option>\n");
      out.write("                                    <option value=\"Cook Islands\">Cook Islands</option>\n");
      out.write("                                    <option value=\"Costa Rica\">Costa Rica</option>\n");
      out.write("                                    <option value=\"Cota D'Ivoire\">Cote d'Ivoire</option>\n");
      out.write("                                    <option value=\"Croatia\">Croatia (Hrvatska)</option>\n");
      out.write("                                    <option value=\"Cuba\">Cuba</option>\n");
      out.write("                                    <option value=\"Cyprus\">Cyprus</option>\n");
      out.write("                                    <option value=\"Czech Republic\">Czech Republic</option>\n");
      out.write("                                    <option value=\"Denmark\">Denmark</option>\n");
      out.write("                                    <option value=\"Djibouti\">Djibouti</option>\n");
      out.write("                                    <option value=\"Dominica\">Dominica</option>\n");
      out.write("                                    <option value=\"Dominican Republic\">Dominican Republic</option>\n");
      out.write("                                    <option value=\"East Timor\">East Timor</option>\n");
      out.write("                                    <option value=\"Ecuador\">Ecuador</option>\n");
      out.write("                                    <option value=\"Egypt\">Egypt</option>\n");
      out.write("                                    <option value=\"El Salvador\">El Salvador</option>\n");
      out.write("                                    <option value=\"Equatorial Guinea\">Equatorial Guinea</option>\n");
      out.write("                                    <option value=\"Eritrea\">Eritrea</option>\n");
      out.write("                                    <option value=\"Estonia\">Estonia</option>\n");
      out.write("                                    <option value=\"Ethiopia\">Ethiopia</option>\n");
      out.write("                                    <option value=\"Falkland Islands\">Falkland Islands (Malvinas)</option>\n");
      out.write("                                    <option value=\"Faroe Islands\">Faroe Islands</option>\n");
      out.write("                                    <option value=\"Fiji\">Fiji</option>\n");
      out.write("                                    <option value=\"Finland\">Finland</option>\n");
      out.write("                                    <option value=\"France\">France</option>\n");
      out.write("                                    <option value=\"France Metropolitan\">France, Metropolitan</option>\n");
      out.write("                                    <option value=\"French Guiana\">French Guiana</option>\n");
      out.write("                                    <option value=\"French Polynesia\">French Polynesia</option>\n");
      out.write("                                    <option value=\"French Southern Territories\">French Southern Territories</option>\n");
      out.write("                                    <option value=\"Gabon\">Gabon</option>\n");
      out.write("                                    <option value=\"Gambia\">Gambia</option>\n");
      out.write("                                    <option value=\"Georgia\">Georgia</option>\n");
      out.write("                                    <option value=\"Germany\">Germany</option>\n");
      out.write("                                    <option value=\"Ghana\">Ghana</option>\n");
      out.write("                                    <option value=\"Gibraltar\">Gibraltar</option>\n");
      out.write("                                    <option value=\"Greece\">Greece</option>\n");
      out.write("                                    <option value=\"Greenland\">Greenland</option>\n");
      out.write("                                    <option value=\"Grenada\">Grenada</option>\n");
      out.write("                                    <option value=\"Guadeloupe\">Guadeloupe</option>\n");
      out.write("                                    <option value=\"Guam\">Guam</option>\n");
      out.write("                                    <option value=\"Guatemala\">Guatemala</option>\n");
      out.write("                                    <option value=\"Guinea\">Guinea</option>\n");
      out.write("                                    <option value=\"Guinea-Bissau\">Guinea-Bissau</option>\n");
      out.write("                                    <option value=\"Guyana\">Guyana</option>\n");
      out.write("                                    <option value=\"Haiti\">Haiti</option>\n");
      out.write("                                    <option value=\"Heard and McDonald Islands\">Heard and Mc Donald Islands</option>\n");
      out.write("                                    <option value=\"Holy See\">Holy See (Vatican City State)</option>\n");
      out.write("                                    <option value=\"Honduras\">Honduras</option>\n");
      out.write("                                    <option value=\"Hong Kong\">Hong Kong</option>\n");
      out.write("                                    <option value=\"Hungary\">Hungary</option>\n");
      out.write("                                    <option value=\"Iceland\">Iceland</option>\n");
      out.write("                                    <option value=\"India\">India</option>\n");
      out.write("                                    <option value=\"Indonesia\">Indonesia</option>\n");
      out.write("                                    <option value=\"Iran\">Iran (Islamic Republic of)</option>\n");
      out.write("                                    <option value=\"Iraq\">Iraq</option>\n");
      out.write("                                    <option value=\"Ireland\">Ireland</option>\n");
      out.write("                                    <option value=\"Israel\">Israel</option>\n");
      out.write("                                    <option value=\"Italy\">Italy</option>\n");
      out.write("                                    <option value=\"Jamaica\">Jamaica</option>\n");
      out.write("                                    <option value=\"Japan\">Japan</option>\n");
      out.write("                                    <option value=\"Jordan\">Jordan</option>\n");
      out.write("                                    <option value=\"Kazakhstan\">Kazakhstan</option>\n");
      out.write("                                    <option value=\"Kenya\">Kenya</option>\n");
      out.write("                                    <option value=\"Kiribati\">Kiribati</option>\n");
      out.write("                                    <option value=\"Democratic People's Republic of Korea\">Korea, Democratic People's Republic of</option>\n");
      out.write("                                    <option value=\"Korea\">Korea, Republic of</option>\n");
      out.write("                                    <option value=\"Kuwait\">Kuwait</option>\n");
      out.write("                                    <option value=\"Kyrgyzstan\">Kyrgyzstan</option>\n");
      out.write("                                    <option value=\"Lao\">Lao People's Democratic Republic</option>\n");
      out.write("                                    <option value=\"Latvia\">Latvia</option>\n");
      out.write("                                    <option value=\"Lebanon\" selected>Lebanon</option>\n");
      out.write("                                    <option value=\"Lesotho\">Lesotho</option>\n");
      out.write("                                    <option value=\"Liberia\">Liberia</option>\n");
      out.write("                                    <option value=\"Libyan Arab Jamahiriya\">Libyan Arab Jamahiriya</option>\n");
      out.write("                                    <option value=\"Liechtenstein\">Liechtenstein</option>\n");
      out.write("                                    <option value=\"Lithuania\">Lithuania</option>\n");
      out.write("                                    <option value=\"Luxembourg\">Luxembourg</option>\n");
      out.write("                                    <option value=\"Macau\">Macau</option>\n");
      out.write("                                    <option value=\"Macedonia\">Macedonia, The Former Yugoslav Republic of</option>\n");
      out.write("                                    <option value=\"Madagascar\">Madagascar</option>\n");
      out.write("                                    <option value=\"Malawi\">Malawi</option>\n");
      out.write("                                    <option value=\"Malaysia\">Malaysia</option>\n");
      out.write("                                    <option value=\"Maldives\">Maldives</option>\n");
      out.write("                                    <option value=\"Mali\">Mali</option>\n");
      out.write("                                    <option value=\"Malta\">Malta</option>\n");
      out.write("                                    <option value=\"Marshall Islands\">Marshall Islands</option>\n");
      out.write("                                    <option value=\"Martinique\">Martinique</option>\n");
      out.write("                                    <option value=\"Mauritania\">Mauritania</option>\n");
      out.write("                                    <option value=\"Mauritius\">Mauritius</option>\n");
      out.write("                                    <option value=\"Mayotte\">Mayotte</option>\n");
      out.write("                                    <option value=\"Mexico\">Mexico</option>\n");
      out.write("                                    <option value=\"Micronesia\">Micronesia, Federated States of</option>\n");
      out.write("                                    <option value=\"Moldova\">Moldova, Republic of</option>\n");
      out.write("                                    <option value=\"Monaco\">Monaco</option>\n");
      out.write("                                    <option value=\"Mongolia\">Mongolia</option>\n");
      out.write("                                    <option value=\"Montserrat\">Montserrat</option>\n");
      out.write("                                    <option value=\"Morocco\">Morocco</option>\n");
      out.write("                                    <option value=\"Mozambique\">Mozambique</option>\n");
      out.write("                                    <option value=\"Myanmar\">Myanmar</option>\n");
      out.write("                                    <option value=\"Namibia\">Namibia</option>\n");
      out.write("                                    <option value=\"Nauru\">Nauru</option>\n");
      out.write("                                    <option value=\"Nepal\">Nepal</option>\n");
      out.write("                                    <option value=\"Netherlands\">Netherlands</option>\n");
      out.write("                                    <option value=\"Netherlands Antilles\">Netherlands Antilles</option>\n");
      out.write("                                    <option value=\"New Caledonia\">New Caledonia</option>\n");
      out.write("                                    <option value=\"New Zealand\">New Zealand</option>\n");
      out.write("                                    <option value=\"Nicaragua\">Nicaragua</option>\n");
      out.write("                                    <option value=\"Niger\">Niger</option>\n");
      out.write("                                    <option value=\"Nigeria\">Nigeria</option>\n");
      out.write("                                    <option value=\"Niue\">Niue</option>\n");
      out.write("                                    <option value=\"Norfolk Island\">Norfolk Island</option>\n");
      out.write("                                    <option value=\"Northern Mariana Islands\">Northern Mariana Islands</option>\n");
      out.write("                                    <option value=\"Norway\">Norway</option>\n");
      out.write("                                    <option value=\"Oman\">Oman</option>\n");
      out.write("                                    <option value=\"Pakistan\">Pakistan</option>\n");
      out.write("                                    <option value=\"Palau\">Palau</option>\n");
      out.write("                                    <option value=\"Panama\">Panama</option>\n");
      out.write("                                    <option value=\"Papua New Guinea\">Papua New Guinea</option>\n");
      out.write("                                    <option value=\"Paraguay\">Paraguay</option>\n");
      out.write("                                    <option value=\"Peru\">Peru</option>\n");
      out.write("                                    <option value=\"Philippines\">Philippines</option>\n");
      out.write("                                    <option value=\"Pitcairn\">Pitcairn</option>\n");
      out.write("                                    <option value=\"Poland\">Poland</option>\n");
      out.write("                                    <option value=\"Portugal\">Portugal</option>\n");
      out.write("                                    <option value=\"Puerto Rico\">Puerto Rico</option>\n");
      out.write("                                    <option value=\"Qatar\">Qatar</option>\n");
      out.write("                                    <option value=\"Reunion\">Reunion</option>\n");
      out.write("                                    <option value=\"Romania\">Romania</option>\n");
      out.write("                                    <option value=\"Russia\">Russian Federation</option>\n");
      out.write("                                    <option value=\"Rwanda\">Rwanda</option>\n");
      out.write("                                    <option value=\"Saint Kitts and Nevis\">Saint Kitts and Nevis</option> \n");
      out.write("                                    <option value=\"Saint LUCIA\">Saint LUCIA</option>\n");
      out.write("                                    <option value=\"Saint Vincent\">Saint Vincent and the Grenadines</option>\n");
      out.write("                                    <option value=\"Samoa\">Samoa</option>\n");
      out.write("                                    <option value=\"San Marino\">San Marino</option>\n");
      out.write("                                    <option value=\"Sao Tome and Principe\">Sao Tome and Principe</option> \n");
      out.write("                                    <option value=\"Saudi Arabia\">Saudi Arabia</option>\n");
      out.write("                                    <option value=\"Senegal\">Senegal</option>\n");
      out.write("                                    <option value=\"Seychelles\">Seychelles</option>\n");
      out.write("                                    <option value=\"Sierra\">Sierra Leone</option>\n");
      out.write("                                    <option value=\"Singapore\">Singapore</option>\n");
      out.write("                                    <option value=\"Slovakia\">Slovakia (Slovak Republic)</option>\n");
      out.write("                                    <option value=\"Slovenia\">Slovenia</option>\n");
      out.write("                                    <option value=\"Solomon Islands\">Solomon Islands</option>\n");
      out.write("                                    <option value=\"Somalia\">Somalia</option>\n");
      out.write("                                    <option value=\"South Africa\">South Africa</option>\n");
      out.write("                                    <option value=\"South Georgia\">South Georgia and the South Sandwich Islands</option>\n");
      out.write("                                    <option value=\"Span\">Spain</option>\n");
      out.write("                                    <option value=\"SriLanka\">Sri Lanka</option>\n");
      out.write("                                    <option value=\"St. Helena\">St. Helena</option>\n");
      out.write("                                    <option value=\"St. Pierre and Miguelon\">St. Pierre and Miquelon</option>\n");
      out.write("                                    <option value=\"Sudan\">Sudan</option>\n");
      out.write("                                    <option value=\"Suriname\">Suriname</option>\n");
      out.write("                                    <option value=\"Svalbard\">Svalbard and Jan Mayen Islands</option>\n");
      out.write("                                    <option value=\"Swaziland\">Swaziland</option>\n");
      out.write("                                    <option value=\"Sweden\">Sweden</option>\n");
      out.write("                                    <option value=\"Switzerland\">Switzerland</option>\n");
      out.write("                                    <option value=\"Syria\">Syrian Arab Republic</option>\n");
      out.write("                                    <option value=\"Taiwan\">Taiwan, Province of China</option>\n");
      out.write("                                    <option value=\"Tajikistan\">Tajikistan</option>\n");
      out.write("                                    <option value=\"Tanzania\">Tanzania, United Republic of</option>\n");
      out.write("                                    <option value=\"Thailand\">Thailand</option>\n");
      out.write("                                    <option value=\"Togo\">Togo</option>\n");
      out.write("                                    <option value=\"Tokelau\">Tokelau</option>\n");
      out.write("                                    <option value=\"Tonga\">Tonga</option>\n");
      out.write("                                    <option value=\"Trinidad and Tobago\">Trinidad and Tobago</option>\n");
      out.write("                                    <option value=\"Tunisia\">Tunisia</option>\n");
      out.write("                                    <option value=\"Turkey\">Turkey</option>\n");
      out.write("                                    <option value=\"Turkmenistan\">Turkmenistan</option>\n");
      out.write("                                    <option value=\"Turks and Caicos\">Turks and Caicos Islands</option>\n");
      out.write("                                    <option value=\"Tuvalu\">Tuvalu</option>\n");
      out.write("                                    <option value=\"Uganda\">Uganda</option>\n");
      out.write("                                    <option value=\"Ukraine\">Ukraine</option>\n");
      out.write("                                    <option value=\"United Arab Emirates\">United Arab Emirates</option>\n");
      out.write("                                    <option value=\"United Kingdom\">United Kingdom</option>\n");
      out.write("                                    <option value=\"United States\">United States</option>\n");
      out.write("                                    <option value=\"United States Minor Outlying Islands\">United States Minor Outlying Islands</option>\n");
      out.write("                                    <option value=\"Uruguay\">Uruguay</option>\n");
      out.write("                                    <option value=\"Uzbekistan\">Uzbekistan</option>\n");
      out.write("                                    <option value=\"Vanuatu\">Vanuatu</option>\n");
      out.write("                                    <option value=\"Venezuela\">Venezuela</option>\n");
      out.write("                                    <option value=\"Vietnam\">Viet Nam</option>\n");
      out.write("                                    <option value=\"Virgin Islands (British)\">Virgin Islands (British)</option>\n");
      out.write("                                    <option value=\"Virgin Islands (U.S)\">Virgin Islands (U.S.)</option>\n");
      out.write("                                    <option value=\"Wallis and Futana Islands\">Wallis and Futuna Islands</option>\n");
      out.write("                                    <option value=\"Western Sahara\">Western Sahara</option>\n");
      out.write("                                    <option value=\"Yemen\">Yemen</option>\n");
      out.write("                                    <option value=\"Yugoslavia\">Yugoslavia</option>\n");
      out.write("                                    <option value=\"Zambia\">Zambia</option>\n");
      out.write("                                    <option value=\"Zimbabwe\">Zimbabwe</option>\n");
      out.write("                                </select>\n");
      out.write("                                <input type=\"text\" class =\"form-control\" name=\"address\" placeholder=\"Your Address\">\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Your Email\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"phoneNumber\" placeholder=\"Your Phone Number\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-submit\">Sign Up</button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>    \n");
      out.write("                </form>    \n");
      out.write("            </div>\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"headertext\">\n");
      out.write("                    FPT UNIVERSITY\n");
      out.write("                </div>\n");
      out.write("                <form action=\"login\" method=\"POST\">\n");
      out.write("                    <div class=\"login\">\n");
      out.write("                        <div class=\"input\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"usr\" name=\"usr\" placeholder=\"Username\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"pwd\" name=\"pwd\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-default\" >Login</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">Sign Up</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <div class=\"logged\">\n");
      out.write("                    Welcome ");
      out.print(request.getAttribute("usr"));
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"middle\">\n");
      out.write("                <a href=\"abc\" data-toggle=\"modal\" data-target=\"#myClass\">Join Class</a>\n");
      out.write("                <a href=\"#\">Timetable</a>\n");
      out.write("                <a href=\"#\">Check Attendance</a>\n");
      out.write("            </div>        \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $(\".logged\").hide();\n");
      out.write("        ");
  String usr = (String) session.getAttribute("logged");
            if (usr != null) {
      out.write("\n");
      out.write("            $(\".login\").hide();\n");
      out.write("            $(\".logged\").show();\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}