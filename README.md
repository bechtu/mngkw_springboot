function staff_training() {

    var participants = IR.findAll();
    var a = 'D';
    for (i = 0; i <= participants.length - 1; i++) {
        var list = participants[i].getSkills();
            if (list.get(i)!== 'D') {
                list.push(a)
            }
        participants[i].setSkills(list);
        IR.save(participants[i]);
    }
}
staff_training()
