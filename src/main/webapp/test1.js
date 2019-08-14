var ind = 1;
$('#open' + ind).click(function() {
    var hBlock = $('#hidd' + ind);
    $(this).text(hBlock.is(':visible') ? 'Подробнее' : 'Скрыть');
    hBlock.toggle('slow');
});
