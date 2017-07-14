$(function() {
    $('#selectall').click(function(){
        if ($("input[name='selectall']").attr("checked")) {
            $(':checkbox').each(
                function() {
                    $(this).attr("checked", true);
                }
            );
        } else {
            $(':checkbox').each(
                function() {
                    if ($(this).attr("checked")) {
                        $(this).removeAttr("checked");
                    }
                }
            );
        }
    });
});
