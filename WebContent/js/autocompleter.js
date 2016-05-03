$(document).ready(function() {
        $(function() {
                $("#search").autocomplete({
                source : function(request, response) {
                        $.ajax({
                                url : "search",
                                type : "POST",
                                data : {
                                        term : request.term
                                },
                                dataType : "json",
                                searched : function(jsonResponse) {
                                        response(jsonResponse.list);
                                }
                        });
                        }
                });
        });
});

