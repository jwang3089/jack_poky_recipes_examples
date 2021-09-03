/** @file vehicle_db_def.h
 *  @brief Data definition for vehicle DB data 
 *
 *  v 0.1
 *
 *  @author 
 */

#ifndef VEHICLE_DB_DEF_H
#define VEHICLE_DB_DEF_H

#include "libsecacc.h"

#define MAX_PART_LENGTH			 (10U)   // TCU max part num length
#define MAX_SERIAL_LENGTH		 (10U)   // TCU max serial num length
#define MAX_VIN_LENGTH			 (17U)   // Vehicle max VIN size
#define MAX_EMAID_LENGTH	     (16U)   // EMAID max length
#define MAX_ICCID_LENGTH     	 (16U)   // ICCID max length
#define MAX_KEY_LENGTH           (16U)   // Max Length for keys
#define MAX_ECUS                   60    
#define MAX_DN_LENGTH            (16U)   //Placeholder


/**
 * @brief 
 *
 * @details 
 * 
 * 
 * @param cert_serial Serial number of the certificate
 * @param cert_status If the certificate is valid
 * @param dn_len Length of the DN
 * @param cert_dn DN of the certificate
 * @param issuer_dn_len Length of the issuer's DN
 * @param cert_issuer_dn DN of the certificate issuer
 * @param cert_expiry When the certificate expires 
 */
typedef struct prov_cert_info
{
    unsigned char cert_serial[MAX_SERIAL_LENGTH];
    bool cert_status;
    uint8_t dn_len;
    unsigned char cert_dn[MAX_DN_LENGTH];
    uint8_t issuer_dn_len;
    unsigned char cert_issuer_dn[MAX_DN_LENGTH];
    uint64_t cert_expiry;
    
} __attribute__((packed, aligned(1))) prov_cert_info_t;

/**
 * @brief 
 *
 * @details 
 * 
 * 
 * @param contract_cert_serial Serial number of the contract certificate
 * @param contract_cert_status Status of of the contract certificate
 * @param con_dn_len Length of the DN
 * @param contract_cert_dn DN of the contract certificate
 * @param con_issuer_dn_len Length of the issuer's DN
 * @param contract_cert_issuer_dn DN of the contract certificate issuer
 * @param contract_cert_expiry When the contract certificate expires
 * 
 */
typedef struct contract_cert_info
{
    unsigned char contract_cert_serial[MAX_SERIAL_LENGTH];
    bool contract_cert_status;
    uint8_t con_dn_len;
    unsigned char contract_cert_dn[MAX_DN_LENGTH];
    uint8_t con_issuer_dn_len;
    unsigned char contract_cert_issuer_dn[MAX_DN_LENGTH];
    uint64_t contract_cert_expiry;

} __attribute__((packed, aligned(1))) contract_cert_info_t;

/**
 * @brief Format struct representing the details and inputs of the algorithms for each ECU
 * 
 * @param algo_name Which algorithm to use at this level
 * @param algo__key Key for the algorithm at this level
 * @param algo_iv IV for the algorithm at this level
 * 
 */
typedef struct lucid_algo
{
    enum algo algo_name;      
    unsigned char algo_key[MAX_KEY_LENGTH];
    unsigned char algo_iv[MAX_KEY_LENGTH];
}__attribute__((packed, aligned(1))) lucid_algo_t;

/**
 * @brief Format struct representing ECU information
 *
 * @details 
 *
 * @param ecu_id Identifier for the type of EC
 * @param part_num_len Length of the ECU's part number
 * @param part_no  The part number of the ECU
 * @param serial_num_len Length of the ECU's serial number
 * @param serial_no The serial number of the ECU
 * @param bl_lvl1_algo Level 1 Bootloader Algorithm 
 * @param bl_lvl2_algo Level 2 Bootloader Algorithm 
 * @param bl_lvl4_algo Level 4 Bootloader Algorithm 
 * @param app_lvl1_algo Level 1 Application Algorithm
 * @param app_lvl2_algo Level 2 Application Algorithm
 * @param app_lvl4_algo Level 4 Application Algorithm
 * @param provision_certificate Certificate assigned to the TCU
 * @param contract_certificate Contract Certificate assigned to the TCU
 * 
 */
typedef struct ecu_data
{
    uint8_t ecu_id;
    uint8_t part_num_len;
    unsigned char part_num[MAX_PART_LENGTH];
    uint8_t serial_num_len;
    unsigned char serial_num[MAX_SERIAL_LENGTH];
    lucid_algo_t bl_lvl1_algo;
    lucid_algo_t bl_lvl2_algo;
    lucid_algo_t bl_lvl4_algo;
    lucid_algo_t app_lvl1_algo;
    lucid_algo_t app_lvl2_algo;
    lucid_algo_t app_lvl4_algo;        
    prov_cert_info_t provision_certificate;
    contract_cert_info_t contract_certificate;

} __attribute__((packed, aligned(1))) ecu_data_t;

//rename cert_info to prov_cert_info
/**
 * @brief Format struct representing TCU information
 * 
 * @details
 * 
 * @param part_num_len Length of the part number
 * @param part_no TCU part number
 * @param serial_no_len Length of the serial number
 * @param serial_no TCU serial number
 * @param provision_certificate Certificate assigned to the TCU
 * @param contract_certificate Contract Certificate assigned to the TCU
 * 
 */
typedef struct tcu_data //Add TCU cert enrollment, expiry
{
    uint8_t part_num_len;
    unsigned char part_num[MAX_PART_LENGTH];
    uint8_t serial_num_len;
    unsigned char serial_num[MAX_SERIAL_LENGTH];
    prov_cert_info_t provision_certificate;
    contract_cert_info_t contract_certificate;
} __attribute__((packed, aligned(1))) tcu_data_t;

/**
 * @param iccid Vehicle ICCID
 * @param emaid Vehicle EMAID
 * @param tcu_info Information from the vehicle's TCU
 * @param ecu_count Number of ECUs in the Vehicle
 * @param ecu_info Array of the ECUs in the Vehicle
 * 
 */
typedef struct vehicle_data //Add TCU cert enrollment, expiry
{
    unsigned char iccid[MAX_ICCID_LENGTH]; 
    unsigned char emaid[MAX_EMAID_LENGTH];
    tcu_data_t tcu_info;
    uint8_t ecu_count;
    ecu_data_t ecu_info[MAX_ECUS];
} __attribute__((packed, aligned(1))) vehicle_data_t;


#endif /*VEHICLE_DB_DEF_H*/
