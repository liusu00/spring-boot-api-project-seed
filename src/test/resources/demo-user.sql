/**
  根据medical_record_backup表跟新medical_record的预约id
 */


UPDATE medical_record a
SET a.appointment_id = (
    SELECT MAX(t.appointment_id)
    FROM medical_record_backup t
    WHERE t.patient_id = a.patient_id AND DATE_FORMAT(t.cjsj,'%Y-%m-%d %H') = DATE_FORMAT(a.create_date,'%Y-%m-%d %H')
      AND t.appointment_id IS NOT NULL AND t.appointment_id <> ''
)
WHERE a.appointment_id IS NULL OR a.appointment_id = ''
;