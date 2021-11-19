<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
         </c:if>

         <p><a href="${pageContext.request.contextPath}/new">新規登録</a></p>

         <table id="data">
              <thead>
                <tr>
                   <th>製品名</th>
                   <th>メーカー</th>
                   <th>発売日</th>
                   <th>在庫</th>
                </tr>
              </thead>

            <c:forEach var="smartphonelist" items="${smartphonelists}">
                        <tbody>
                         <tr>
                            <td><a href="${pageContext.request.contextPath}/show?id=${smartphonelist.id}">
                            <c:out value="${smartphonelist.product_name}" /></a></td>
                            <td><c:out value="${smartphonelist.manufacturing_company}" /></td>
                            <td><c:out value="${smartphonelist.release_date}" /></td>
                            <td><c:out value="${smartphonelist.stock}" /></td>
                         </tr>
                        </tbody>
             </c:forEach>
         </table>

     </c:param>
</c:import>