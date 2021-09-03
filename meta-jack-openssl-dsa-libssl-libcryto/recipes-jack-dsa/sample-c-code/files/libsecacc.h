#ifndef LIBSESECACC_H
#define LIBSESECACC_H

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#include <mbedtls/entropy.h>
#include <mbedtls/ctr_drbg.h>
#include <mbedtls/aes.h>

#define LIBSEC_AES_SEED_LEN 16
#define LIBSEC_RCM_SEED_LEN 4
#define LIBSEC_LUCID_CUSTOM_SEED_LEN 4

/**
 * @brief Data types for determining the algorithm to use
 *
 */
enum algo { RCM_BL, RCM_APP, LUCID_CUS, AES_128_CBC, AES_128_ECB, RCM };

/**
 * @brief Specify the AES mode and whether to encrypt or decrypt
 * 
 */
enum aes_modes { AES_CBC_ENC, AES_CBC_DEC, AES_ECB_ENC, AES_ECB_DEC };

/**
 * @brief Data types for determining whether RCM to use
 *
 */
enum rcm_usage { NON_RCM = 0, RCM_BOOT, RCM_APPS };

typedef enum {
    LIBSEC_SUCCESS  = 0,
    LIBSEC_ENCRYPTION_FAILED,
    LIBSEC_INVALID_ECU_ID,
    LIBSEC_NO_ECU_LIST,
    LIBSEC_INVALID_SECURITY_LEVEL,
    LIBSEC_INVALID_KEY_LEVEL,
    LIBSEC_INVALID_IV_KEY_LEN,
    LIBSEC_INTERNAL_ERR,
    LIBSEC_INVALID_KEY_DATA,
    LIBSEC_INVALID_SEED_DATA,
    LIBSEC_INVALID_SEED_LEN
} libsecacc_ret_t;

/**
 * @brief Struct for the seed, magic, and aes inputs to be fed into a single function
 * 
 * @param ecu_id type of ECU to encrypt
 * @param key_level level 1, 3, 7
 * @param aes_mode Whether to encrypt or decrypt
 * @param src_buff_len Length of said buffer
 * @param src_buf Buffer of data to be encrypted/decrypted
 * @param dst_buff_len Length of the buffer being sent
 * @param dst_buf Buffer to store the data in
 * 
 */
#define MAX_ECU_NUM 120
#define MAX_ECU_ID_LEN 12

typedef struct algo_inputs_t
{
    uint32_t ecu_id;
    uint32_t key_level;
    enum aes_modes mode;
    uint32_t src_buf_len;
    unsigned char *src_buf;
    uint32_t dst_buf_len;
    unsigned char *dst_buf;
} algo_inputs_t;

/**
 * @brief Selects the algorithm to run
 * @param choice Which algorithm to use
 * @param fruit The parameters for any given algorithm
 */
libsecacc_ret_t select_algo(algo_inputs_t *input);

/**
 * @brief Gets the bit at the specified position
 * @param selected_bit The bit position to be extracted
 * @param origin The source of the data
 * @return The single bit at the specific position
 * 
 */
unsigned int bit_at( unsigned int selected_bit, unsigned char origin );

/**
 * @brief Performs cyclical bit rightward rotation for 4 byte char array inputs
 * @param arr The input to be rotated
 * @param shift The number of bit shifts
 * @param right Whether to rotate right or left. Left is 0, right is 1. Left will perform 16 - shift right bit shifts, which is the same as shift left bit shfits
 */
void rotation(unsigned char* arr, unsigned int shift, bool right);

/**
 * @brief The algorithm for the RCM Bootloader
 * @param seed The input to be used as the seed for the key
 * @return LCKEY_LEN
 */
uint32_t rcm_bl(const unsigned char* seed,unsigned char* output);

/**
 * @brief The algorithm for the RCM Application
 * @param seed The input to be used as the seed for the key
 * @return LCKEY_LEN
 */
uint32_t rcm_app(unsigned char* seed,unsigned char* output);

/**
 * @brief The algorithm for the Lucid Custom Algorithm
 * @param seed_len The lucid custom seed length
 * @param seed The seed for the key
 * @param magic The magic number for the algorithm
 * @return The key returned from the Lucid Custom Algorithm
 */
uint32_t lucid_cus(uint32_t seed_len, const unsigned char* seed, const unsigned char* magic, unsigned char* output);

/**
 * @brief Creates an AES key using mbedtls APIs
 * @param key Buffer to store the generated key in
 */
void gen_aes_key(unsigned char* key);

/**
 * @brief AES 128 CBC encryption
 * @param key_str Key for encryption
 * @param key_len Length of key
 * @param iv_str Initialization Vector
 * @param iv_len Length of Initialization Vector
 * @param src_buf Source buffer
 * @param src_buf_len Length of source buffer
 * @param dst_buf Destination Buffer
 * @param mode AES mode and whether to encrypt or decrypt
 * @return Length of Destination Buffer
 */
uint32_t aes_cbc_crypt( unsigned const char * key_str, uint32_t key_len, unsigned char * iv_str, uint32_t iv_len,
                      unsigned char * src_buf, uint32_t src_buf_len, unsigned char * dst_buf,
                      enum aes_modes mode);

/**
 * @brief AES 128 ECB encryption
 * @param key_str Key for encryption
 * @param key_len Length of key
 * @param src_buf Source buffer
 * @param src_buf_len Length of source buffer
 * @param dst_buf Destination Buffer
 * @param mode AES mode and whether to encrypt or decrypt
 * @return Length of Destination Buffer
 */
uint32_t aes_ecb_crypt( unsigned const char * key_str, uint32_t key_len,
                      unsigned char * src_buf, uint32_t src_buf_len, unsigned char * dst_buf,
                      enum aes_modes mode);

#endif /*LIBSESECACC_H*/
