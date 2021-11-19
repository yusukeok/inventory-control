<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>${smartphonelist.product_name} の詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>製品名</th>
                    <td><c:out value="${smartphonelist.product_name}" /></td>
                </tr>
                <tr>
                    <th>メーカー</th>
                    <td><c:out value="${smartphonelist.manufacturing_company}" /></td>
                </tr>
                 <tr>
                    <th>発売日</th>
                    <td><c:out value="${smartphonelist.release_date}" /></td>
                 </tr>
                 <tr>
                    <th>在庫</th>
                    <td><c:out value="${smartphonelist.stock}" /></td>
                  </tr>
             </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/edit?id=${smartphonelist.id}">編集</a></p>
        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>

    </c:param>
</c:import>