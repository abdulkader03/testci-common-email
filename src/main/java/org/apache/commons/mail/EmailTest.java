package org.apache.commons.mail;

import static org.junit.jupiter.api.Assertions.*; // Importing necessary assertion methods
import org.junit.jupiter.api.Test; // Importing Test annotation
import org.apache.commons.mail.Email; // Importing Email class
import org.apache.commons.mail.EmailException; // Importing EmailException class
import org.apache.commons.mail.SimpleEmail; // Importing SimpleEmail class
import javax.mail.Session; // Importing Session class
import java.util.Date; // Importing Date class

// Created by Abdul
class EmailTest { // Test class definition

    @Test
    void testAddBccStringArray() throws EmailException { // Testing the addBcc method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.addBcc("bcc1@example.com", "bcc2@example.com"); // Adding Bcc addresses
        assertEquals(2, email.getBccAddresses().size()); // Verifying if both Bcc addresses are added
    }

    @Test
    void testAddCcString() throws EmailException { // Testing the addCc method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.addCc("cc@example.com"); // Adding Cc address
        assertEquals(1, email.getCcAddresses().size()); // Verifying if Cc address is added
    }

    @Test
    void testAddHeader() { // Testing the addHeader method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.addHeader("Test-Header", "Test-Value"); // Adding a custom header
        assertTrue(email.hasHeader("Test-Header")); // Verifying if the header is added
        assertEquals("Test-Value", email.getHeaderValue("Test-Header")); // Verifying the header value
    }

    @Test
    void testAddReplyToStringString() throws EmailException { // Testing the addReplyTo method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.addReplyTo("reply@example.com", "Reply Name"); // Adding reply-to address
        assertEquals(1, email.getReplyToAddresses().size()); // Verifying if reply-to address is added
    }

    @Test
    void testBuildMimeMessage() { // Testing the buildMimeMessage method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        assertThrows(IllegalStateException.class, () -> email.buildMimeMessage()); // Verifying if IllegalStateException is thrown
    }

    @Test
    void testGetHostName() throws EmailException { // Testing the getHostName method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.setHostName("smtp.example.com"); // Setting hostname
        assertEquals("smtp.example.com", email.getHostName()); // Verifying if hostname is retrieved correctly
    }

    @Test
    void testGetMailSession() throws EmailException { // Testing the getMailSession method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.setHostName("smtp.example.com"); // Setting hostname
        Session session = email.getMailSession(); // Retrieving mail session
        assertNotNull(session); // Verifying if session is not null
    }

    @Test
    void testGetSentDate() { // Testing the getSentDate method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        Date sentDate = email.getSentDate(); // Retrieving sent date
        assertNotNull(sentDate); // Verifying if sent date is not null
    }

    @Test
    void testGetSocketConnectionTimeout() { // Testing the getSocketConnectionTimeout method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        assertEquals(0, email.getSocketConnectionTimeout()); // Verifying if socket connection timeout is 0
    }

    @Test
    void testSetFrom() throws EmailException { // Testing the setFrom method
        Email email = new SimpleEmail(); // Creating a SimpleEmail object
        email.setFrom("from@example.com"); // Setting from address
        assertEquals("from@example.com", email.getFromAddress().toString()); // Verifying if from address is set correctly
    }
}
