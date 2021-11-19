<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label>メーカー<br />
<input type="text" name="manufacturing_company" value="${stock.manufacturing_company}" />
</label>
<br /><br />
<label>製品名<br />
<input type="text" name="product_name" value="${stock.product_name}" />
</label>
<br /><br />
<label>発売日<br />
<input type="text" name="release_date" value="${stock.relese_date}" />
</label>
<br /><br />
<label>在庫<br />
<input type="text" name="stock" value="${stock.stock}" />
</label>
<br /><br />
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
