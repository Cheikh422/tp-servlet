<%@tag description="User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="userName" required="true"%>

<t:genericpage>
    <jsp:attribute name="header">
      <h1>Welcome ${userName}</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 2019, Cheikh EJEYED.</p>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</t:genericpage>