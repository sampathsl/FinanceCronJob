package com.intervest.finance.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecurityHelperFunctions {
	
	private static Log log = LogFactory.getLog(SecurityHelperFunctions.class.getName());
	private static final BASE64Encoder b64enc = new BASE64Encoder();
	private static final BASE64Decoder b64dec = new BASE64Decoder();
	private static byte[] keyBytes;
	
	static{
		try{
			MessageDigest md = MessageDigest.getInstance( "SHA-512" );
			byte[] digestOfPassword1 = md.digest( "666".getBytes( "UTF-8" ) );
			byte[] digestOfPassword2 = md.digest( "777".getBytes( "UTF-8" ) );
			keyBytes = Arrays.copyOf( digestOfPassword1, 24 );
			System.arraycopy( digestOfPassword2, 0, keyBytes, 16, 8 );
		} catch( NoSuchAlgorithmException nsae ) {
			log.error( nsae );
		} catch( UnsupportedEncodingException usee ) {
			log.error( usee );
		}
	}

	/**  */
	public static String encodeMessage( String message ) {
		try {
			SecretKey key = new SecretKeySpec( keyBytes, "DESede" );
			IvParameterSpec iv = new IvParameterSpec( new byte[8] );
			Cipher cipher = Cipher.getInstance( "DESede/CBC/PKCS5Padding" );
			cipher.init( Cipher.ENCRYPT_MODE, key, iv );
			byte[] cipherText = cipher.doFinal( message.getBytes() );
			return b64enc.encode( cipherText );
		} catch( NoSuchAlgorithmException nsae ) {
			log.error( nsae );
		} catch( NoSuchPaddingException nspe ) {
			log.error( nspe );
		} catch( InvalidAlgorithmParameterException iape ) {
			log.error( iape );
		} catch( InvalidKeyException ike ) {
			log.error( ike );
		} catch( BadPaddingException bpe ) {
			log.error( bpe );
		} catch( IllegalBlockSizeException ibse ) {
			log.error( ibse );
		}
		return null;
	}

	/**  */
	public static String decodeMessage( String encodedMessage ) {
		try {
			final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
	        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
	        final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
	        decipher.init(Cipher.DECRYPT_MODE, key, iv);
	        
	        return new String( decipher.doFinal( b64dec.decodeBuffer( encodedMessage )), "UTF-8" );
		} catch( InvalidKeyException ike ) {
			log.error( ike );
		} catch( InvalidAlgorithmParameterException iape ) {
			log.error( iape );
		} catch( NoSuchPaddingException nspe ) {
			log.error( nspe );
		} catch( BadPaddingException bpe ) {
			log.error( bpe );
		} catch( IllegalBlockSizeException ibse ) {
			log.error( ibse );
		} catch( UnsupportedEncodingException usee ) {
			log.error( usee );
		} catch( NoSuchAlgorithmException nsae ) {
			log.error( nsae );
		} catch( IOException ioe ) {
			log.error( ioe );
		}
		return null;
	}

	/*public static void main( String[] arg ) {
		System.out.println( encodeMessage( "1" ) );
		System.out.println( encodeMessage( "1" ) );
		System.out.println( encodeMessage( "1" ) );
		System.out.println( encodeMessage( "1" ) );
		System.out.println( decodeMessage( "=" ) );
		System.out.println( decodeMessage( "gf=" ) );
		System.out.println( decodeMessage( "fg=" ) );
		System.out.println( decodeMessage( "fg=" ) );
	}*/

}
