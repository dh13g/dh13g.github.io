SELECT 
enc.Id, 
'Diagnosis' as CodeType,																	-- If it is from Diagnosis code display "Diagnosis"
enc.totalcharges AS 'Payment Pre',															-- Pre Payment - Total Charge
enc.remittanceadvicepaymentamount AS 'Payment Post',										-- Post Payment - Remittance Advice                                                                                       
null as 'HardCode PRX Pre',                                                              
null as 'HardCode PRX Post',                                                             
NULL AS 'Modifier',                                                             
null AS 'SoftCode PRX Pre',                                                       
null AS 'SoftCode PRX Post',
NULL AS 'Modifier',
CASE WHEN dg.codeoriginal IS NOT NULL THEN dg.codeoriginal									-- If codeoriginal is not null display codeoriginal code
	 WHEN dg.deleted = 1 AND dg.created = 0 THEN dg.code									-- If it is deleted and but created display post code		
	 WHEN dg.deleted = 0 AND dg.created = 1 THEN NULL										-- If it is not deleted but created then display null
	 WHEN dg.deleted = 0 AND dg.created = 0 THEN dg.code									-- If it is not deleted nor created display post code
	 END AS 'DX Pre',                                                                                  
CASE WHEN dg.codeoriginal IS NOT NULL THEN dg.code											-- If codeoriginal is not null display post code
	 WHEN dg.deleted = 1 AND dg.created = 0 THEN NULL										-- If it is deleted and but created display null	
	 WHEN dg.deleted = 0 AND dg.created = 1 THEN dg.code									-- If it is not deleted but created then display post code
	 WHEN dg.deleted = 0 AND dg.created = 0 THEN dg.code									-- If it is not deleted nor created display post code
	 END as 'DX Post'
INTO #Detail
FROM encounter enc
inner JOIN diagnosis dg ON dg.encounterid = enc.Id
WHERE enc.ServiceType IN ('AMB', 'OP', 'CLN')												--
UNION ALL
SELECT 
pr.EncounterId, 
'Procedure' as CodeType,																	-- If they grab a code from procedure table, specify "Procedure"
enc.totalcharges AS 'Payment Pre',															-- Pre Payment - Total Charge
enc.remittanceadvicepaymentamount AS 'Payment Post',											-- Post Payment - Remittance Advice           
CASE WHEN pr.ishardcode = 1 THEN pr.codeoriginal											-- If it is hardcode = 1 then write codeoriginal for Hardcode PRX pre
       WHEN pr.ishardcode = 0 THEN NULL
	   WHEN pr.ishardcode = 1 AND pr.codeoriginal IS NOT NULL THEN pr.codeoriginal	
	   WHEN pr.codeoriginal IS NOT NULL THEN pr.codeoriginal		
       WHEN pr.ishardcode = 1 AND pr.deleted = 1 AND pr.created = 0 THEN pr.code
	   WHEN pr.deleted = 1 AND pr.created = 0 THEN pr.code  
        WHEN pr.ishardcode = 1 AND pr.deleted = 0 AND pr.created = 0 THEN pr.code 
		WHEN pr.deleted = 0 AND pr.created = 0 THEN pr.code
        END AS 'HardCode PRX Pre',                                                              
CASE WHEN pr.ishardcode = 1 THEN pr.code
		WHEN pr.ishardcode = 0 THEN NULL
       WHEN pr.ishardcode = 1 AND pr.codeoriginal IS NOT NULL THEN pr.code					-- If it is hardcode = 1 then write codeoriginal for Hardcode PRX post
       WHEN pr.codeoriginal IS NOT NULL THEN pr.code
	   WHEN pr.ishardcode = 1 AND pr.deleted = 0 AND pr.created = 1 THEN pr.code
	   WHEN pr.deleted = 0 AND pr.created = 1 THEN pr.code
       WHEN pr.ishardcode = 1 AND pr.deleted = 0 AND pr.created = 0 THEN pr.code 
	   WHEN pr.deleted = 0 AND pr.created = 0 THEN pr.code 
        END AS 'HardCode PRX Post',    
--CASE WHEN pr.ishardcode = 1 THEN CONCAT(pr.Modifier1, ',', pr.Modifier2 , ',', pr.Modifier3, ',', pr.Modifier4) END as Modifier,                                                           
CASE WHEN pr.ishardcode = 0 THEN pr.codeoriginal											-- If it is softcode = 1 then write codeoriginal for Softcode PRX pre
        WHEN pr.ishardcode = 1 THEN NULL
		WHEN pr.ishardcode = 0 AND pr.codeoriginal IS NOT NULL THEN pr.codeoriginal	
		WHEN pr.codeoriginal IS NOT NULL THEN pr.codeoriginal
        WHEN pr.ishardcode = 0 AND pr.deleted = 1 AND pr.created = 0 THEN pr.code 
		WHEN pr.deleted = 1 AND pr.created = 0 THEN pr.code 
        WHEN pr.ishardcode = 0 AND pr.deleted = 0 AND pr.created = 0 THEN pr.code
		WHEN pr.deleted = 0 AND pr.created = 0 THEN pr.code 
       END AS 'SoftCode PRX Pre',                                                              
CASE WHEN pr.ishardcode = 0 THEN pr.code													-- If it is softcode = 1 then write codeoriginal for Softcode PRX post
       WHEN pr.ishardcode = 1 THEN NULL
	   WHEN pr.ishardcode = 0 AND pr.codeoriginal IS NOT NULL THEN pr.code
	   WHEN pr.codeoriginal IS NOT NULL THEN pr.code
       WHEN pr.ishardcode = 0 AND pr.deleted = 0 AND pr.created = 1 THEN pr.code
	   WHEN pr.deleted = 0 AND pr.created = 1 THEN pr.code									--If it is created should it be in softcode? even though hardcode is null
       WHEN pr.ishardcode = 0 AND pr.deleted = 0 AND pr.created = 0 THEN pr.code  
	   WHEN pr.deleted = 0 AND pr.created = 0 THEN pr.code 
        END AS 'SoftCode PRX Post',
--CASE WHEN pr.ishardcode = 1 THEN CONCAT(pr.Modifier1, ',', pr.Modifier2 , ',', pr.Modifier3, ',', pr.Modifier4) END as Modifier,  
NULL AS 'DX Pre',                                                                                  
null as 'DX Post'
FROM encounter enc
INNER JOIN dbo.[procedure] pr ON pr.encounterid = enc.id 
WHERE enc.ServiceType IN ('AMB', 'OP', 'CLN')
Order by 1,2