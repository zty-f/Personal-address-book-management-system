<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body bgcolor="#CCCFFF">
    <table align="center">
        <tr>
            <td colspan="3" align="center">
                <h3><font color="red">请填写一下注册信息</font></h3>
            </td>
        </tr>
        <tr>
            <td>
                <form action="SignUpServlet" method="post">
                    <table border="2" cellspacing="0" cellpadding="0"
                    bgcolor="#AAABBB">
                        <tr>
                            <td>登录名字</td>
                            <td><input type="text" name="userName" size="22"></td>
                        </tr>
                        <tr>
                            <td>用户密码</td>
                            <td><input type="password" name="password1" size="22"></td>
                        </tr>
                        <tr>
                            <td>重复密码</td>
                            <td><input type="password" name="password2" size="22"></td>
                        </tr>
                        <tr>
                            <td>用户姓名</td>
                            <td><input type="text" name="name" size="22" title=""></td>
                        </tr>
                        <tr>
                            <td>用户性别</td>
                            <td><input type="radio" name="sex" value="男" checked/>男
                            <input type="radio" name="sex" value="女">女</td>
                        </tr>
                        <tr>
                            <td>出生日期</td>
                            <td>
                                <select name="year" size="1">
                                    <option value="1987">1987</option>
                                    <option value="1988">1988</option>
                                    <option value="1989">1989</option>
                                    <option value="1990">1990</option>
                                    <option value="1991">1991</option>
                                    <option value="1992">1992</option>
                                    <option value="1993">1993</option>
                                    <option value="1994">1994</option>
                                    <option value="1995">1995</option>
                                    <option value="1996">1996</option>
                                </select>年
                                <select name="month" size="1">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>月
                                <select name="day" size="1">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                </select>月
                            </td>
                        </tr>
                        <tr>
                            <td>用户民族</td>
                            <td>
                                <input type="radio" name="nation" value="汉族" checked>汉族
                                <input type="radio" name="nation" value="满足" checked>满族
                                <input type="radio" name="nation" value="壮族" checked>壮族
                                <input type="radio" name="nation" value="其他" checked>其他
                            </td>
                        </tr>
                        <tr>
                            <td>用户学历</td>
                            <td>
                                <select name="edu" size="1">
                                    <option value="本科">本科</option>
                                    <option value="博士">博士</option>
                                    <option value="其他">其他</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>用户职称</td>
                            <td>
                                <select name="work" size="1">
                                    <option value="软件开发工程师">软件开发工程师</option>
                                    <option value="软件测试工程师">软件测试工程师</option>
                                    <option value="其他">其他</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>用户电话</td>
                            <td>
                                <input type="text" name="phone" size="20">
                            </td>
                        </tr>
                        <tr>
                            <td>家庭住址</td>
                            <td>
                                <select name="place" size="1">
                                    <option value="北京">北京</option>
                                    <option value="上海">上海</option>
                                    <option value="天津">天津</option>
                                    <option value="河北">河北</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>邮箱地址</td>
                            <td>
                                <input type="text" name="email" size="20">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="确定" size="12">
                                <input type="reset" value="清除" size="12"></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
