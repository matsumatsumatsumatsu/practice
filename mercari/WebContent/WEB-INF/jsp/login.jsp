<%@page pageEncoding="WIndows-31J"
  contentType="text/html;charset=Windows-31J"%>

  <html>
    <head>
      <title>ログイン</title>
    </head>
    <body>
      <h1>ログイン</h1>
      <form action="authenticate" method="post">
        名前：<input type="text" name="name"/><br>
        パスワード：<input type="text" name="pass"/><br><br>
        <input type="submit" value="ログイン">
      </form>
    </body>
  </html>