/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $('input').on('click', function () {
        var Status = $(this)
        $.ajax({
            url: 'request',
            data: {
                text: $("textarea[name=Status]").val(),
                Status: Status
            },
            dataType : 'json'
        });
    });
});