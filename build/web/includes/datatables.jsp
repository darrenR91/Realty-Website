<%-- 
    Document   : datatables
    Created on : 18-Dec-2015, 13:39:21
    Author     : Darren
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/s/dt/jq-2.1.4,dt-1.10.10/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/s/dt/jq-2.1.4,dt-1.10.10/datatables.min.js"></script>
        <link href="/RealtyWebsite/css/media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="/RealtyWebsite/css/media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="/RealtyWebsite/css/media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="/RealtyWebsite/css/media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="/RealtyWebsite/css/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <script src="/RealtyWebsite/css/scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="/RealtyWebsite/css/scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        $(document).ready(function () {
            $("#Properties").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>