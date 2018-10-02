SELECT ac.action_id, count(ac.action_id) as TOTAL_COUNT, tra.translation_id, tra.code 
FROM hims_audit_index ac
LEFT JOIN hai_audit_action ha on ac.action_id = ha.action_id 
LEFT JOIN (SELECT translation_id, code FROM strm_translation WHERE translation_id IN (SELECT translation_id FROM hai_audit_action)) tra on ha.translationid = tra.translation_id 
WHERE date_time between to_date('01/01/2017', 'DD/MM/YYYY') AND date_time between to_date('12/31/2017', 'DD/MM/YYYY') 
GROUP BY ac.action_id, tra.translation_id, tra.code;