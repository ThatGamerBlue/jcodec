package org.jcodec.containers.mxf;

import java.util.HashMap;
import java.util.Map;

import org.jcodec.common.Codec;
import org.jcodec.containers.mxf.read.ContentStorage;
import org.jcodec.containers.mxf.read.GenericDescriptor;
import org.jcodec.containers.mxf.read.IndexSegment;
import org.jcodec.containers.mxf.read.MXFMetadata;
import org.jcodec.containers.mxf.read.MXFPartitionPack;
import org.jcodec.containers.mxf.read.MaterialPackage;
import org.jcodec.containers.mxf.read.Sequence;
import org.jcodec.containers.mxf.read.SourceClip;
import org.jcodec.containers.mxf.read.SourcePackage;
import org.jcodec.containers.mxf.read.Track;
import org.jcodec.containers.mxf.read.UL;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * @author The JCodec project
 * 
 */
public class MXFConst {

    public static UL HEADER_PARTITION_KLV = new UL(0x06, 0x0e, 0x2b, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02,
            0x01, 0x01, 0x02);

    public static UL INDEX_KLV = new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
            0x10, 0x01, 0x00);

    public static UL GENERIC_DESCRIPTOR_KLV = new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01,
            0x01, 0x01, 0x01);

    public static enum MXFCodecMapping {

        MPEG2_ML(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x03, 0x04, 0x01, 0x02, 0x02, 0x01, 0x01, 0x11, 0x00),
                Codec.MPEG2),

        MPEG2_D10_PAL(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x01, 0x02, 0x02, 0x01, 0x02, 0x01,
                0x01), Codec.MPEG2),

        MPEG2_HL(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x03, 0x04, 0x01, 0x02, 0x02, 0x01, 0x03, 0x03, 0x00),
                Codec.MPEG2),

        MPEG2_HL_422_I(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x03, 0x04, 0x01, 0x02, 0x02, 0x01, 0x04, 0x02,
                0x00), Codec.MPEG2),

        MPEG4_XDCAM_PROXY(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x03, 0x04, 0x01, 0x02, 0x02, 0x01, 0x20,
                0x02, 0x03), Codec.MPEG4),

        DV_25_PAL(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x01, 0x02, 0x02, 0x02, 0x01, 0x02, 0x00),
                Codec.DV),

        JPEG2000(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x07, 0x04, 0x01, 0x02, 0x02, 0x03, 0x01, 0x01, 0x00),
                Codec.J2K),

        RAW(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x01, 0x02, 0x01, 0x7F, 0x00, 0x00, 0x00),
                null),

        VC3_DNXD(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x01, 0x02, 0x02, 0x03, 0x02, 0x00, 0x00),
                Codec.VC3),

        AVC_INTRA(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x0A, 0x04, 0x01, 0x02, 0x02, 0x01, 0x32, 0x00, 0x00),
                Codec.H264),

        V210(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x0A, 0x04, 0x01, 0x02, 0x01, 0x01, 0x02, 0x02, 0x00),
                Codec.V210),

        PCM_S16LE_1(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x02, 0x02, 0x01, 0x00), null),
        
        PCM_S16LE_3(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x02, 0x02, 0x01, 0x01), null),

        PCM_S16LE_2(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x02, 0x02, 0x01, 0x7F), null),

        PCM_S16BE(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x07, 0x04, 0x02, 0x02, 0x01, 0x7E), null),

        PCM_ALAW(
                new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x04, 0x04, 0x02, 0x02, 0x02, 0x03, 0x01, 0x01, 0x00),
                Codec.ALAW),

        AC3(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x02, 0x02, 0x02, 0x03, 0x02, 0x01, 0x00),
                Codec.AC3),

        MP2(new UL(0x06, 0x0E, 0x2B, 0x34, 0x04, 0x01, 0x01, 0x01, 0x04, 0x02, 0x02, 0x02, 0x03, 0x02, 0x05, 0x00),
                Codec.MP3);

        private UL ul;
        private Codec codec;

        private MXFCodecMapping(UL ul, Codec codec) {
            this.ul = ul;
            this.codec = codec;
        }

        public UL getUl() {
            return ul;
        }

        public Codec getCodec() {
            return codec;
        }
    };

    public static Map<UL, Class<? extends MXFMetadata>> klMetadataMapping = new HashMap<UL, Class<? extends MXFMetadata>>();

    static {
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x18, 0x00), ContentStorage.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x37, 0x00), SourcePackage.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x0F, 0x00), Sequence.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x11, 0x00), SourceClip.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x3A, 0x00), Track.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x3B, 0x00), Track.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x36, 0x00), MaterialPackage.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x10, 0x01, 0x00), IndexSegment.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x44, 0x00), GenericDescriptor.class);
        // Generic Sound
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x42, 0x00), GenericDescriptor.class);
        // CDCI
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x28, 0x00), GenericDescriptor.class);
        // RGBA
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x29, 0x00), GenericDescriptor.class);
        // MPEG 2 Video
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x51, 0x00), GenericDescriptor.class);
        // Wave
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x48, 0x00), GenericDescriptor.class);
        // AES3
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x53, 0x01, 0x01, 0x0d, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x47, 0x00), GenericDescriptor.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x05, 0x01, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x02, 0x01, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x02, 0x02, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x02, 0x03, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x02, 0x04, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x03, 0x01, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x03, 0x02, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x03, 0x03, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x03, 0x04, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x04, 0x02, 0x00), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(0x06, 0x0E, 0x2B, 0x34, 0x02, 0x05, 0x01, 0x01, 0x0d, 0x01, 0x02, 0x01, 0x01,
                0x04, 0x04, 0x00), MXFPartitionPack.class);

    }

    // {PIX_FMT_ABGR, {'A', 8, 'B', 8, 'G', 8, 'R', 8 }
    // {PIX_FMT_ARGB, {'A', 8, 'R', 8, 'G', 8, 'B', 8 }
    // {PIX_FMT_BGR24, {'B', 8, 'G', 8, 'R', 8 }
    // {PIX_FMT_BGRA, {'B', 8, 'G', 8, 'R', 8, 'A', 8 }
    // {PIX_FMT_RGB24, {'R', 8, 'G', 8, 'B', 8 }
    // {PIX_FMT_RGB444BE,{'F', 4, 'R', 4, 'G', 4, 'B', 4 }
    // {PIX_FMT_RGB48BE, {'R', 8, 'r', 8, 'G', 8, 'g', 8, 'B', 8, 'b', 8 }
    // {PIX_FMT_RGB48BE, {'R', 16, 'G', 16, 'B', 16 }
    // {PIX_FMT_RGB48LE, {'r', 8, 'R', 8, 'g', 8, 'G', 8, 'b', 8, 'B', 8 }
    // {PIX_FMT_RGB555BE,{'F', 1, 'R', 5, 'G', 5, 'B', 5 }
    // {PIX_FMT_RGB565BE,{'R', 5, 'G', 6, 'B', 5 }
    // {PIX_FMT_RGBA, {'R', 8, 'G', 8, 'B', 8, 'A', 8 }
    // {PIX_FMT_PAL8, {'P', 8 }

    // static const MXFLocalTagPair mxf_local_tag_batch[] = {
    // preface set
    // { 0x3C0A,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x01,0x01,0x15,0x02,0x00,0x00,0x00,0x00}},
    // /* Instance UID */
    // { 0x3B02,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x10,0x02,0x04,0x00,0x00}},
    // /* Last Modified Date */
    // { 0x3B05,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x03,0x01,0x02,0x01,0x05,0x00,0x00,0x00}},
    // /* Version */
    // { 0x3B06,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x06,0x04,0x00,0x00}},
    // /* Identifications reference */
    // { 0x3B03,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x02,0x01,0x00,0x00}},
    // /* Content Storage reference */
    // { 0x3B09,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x01,0x02,0x02,0x03,0x00,0x00,0x00,0x00}},
    // /* Operational Pattern UL */
    // { 0x3B0A,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x01,0x02,0x02,0x10,0x02,0x01,0x00,0x00}},
    // /* Essence Containers UL batch */
    // { 0x3B0B,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x01,0x02,0x02,0x10,0x02,0x02,0x00,0x00}},
    // /* DM Schemes UL batch */
    // Identification
    // { 0x3C09,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x05,0x20,0x07,0x01,0x01,0x00,0x00,0x00}},
    // /* This Generation UID */
    // { 0x3C01,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x05,0x20,0x07,0x01,0x02,0x01,0x00,0x00}},
    // /* Company Name */
    // { 0x3C02,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x05,0x20,0x07,0x01,0x03,0x01,0x00,0x00}},
    // /* Product Name */
    // { 0x3C04,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x05,0x20,0x07,0x01,0x05,0x01,0x00,0x00}},
    // /* Version String */
    // { 0x3C05,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x05,0x20,0x07,0x01,0x07,0x00,0x00,0x00}},
    // /* Product ID */
    // { 0x3C06,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x10,0x02,0x03,0x00,0x00}},
    // /* Modification Date */
    // Content Storage
    // { 0x1901,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x05,0x01,0x00,0x00}},
    // /* Package strong reference batch */
    // { 0x1902,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x05,0x02,0x00,0x00}},
    // /* Package strong reference batch */
    // Essence Container Data
    // { 0x2701,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x06,0x01,0x00,0x00,0x00}},
    // /* Linked Package UID */
    // { 0x3F07,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x01,0x03,0x04,0x04,0x00,0x00,0x00,0x00}},
    // /* BodySID */
    // Package
    // { 0x4401,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x01,0x01,0x15,0x10,0x00,0x00,0x00,0x00}},
    // /* Package UID */
    // { 0x4405,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x10,0x01,0x03,0x00,0x00}},
    // /* Package Creation Date */
    // { 0x4404,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x10,0x02,0x05,0x00,0x00}},
    // /* Package Modified Date */
    // { 0x4403,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x06,0x05,0x00,0x00}},
    // /* Tracks Strong reference array */
    // { 0x4701,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x02,0x03,0x00,0x00}},
    // /* Descriptor */
    // Track
    // { 0x4801,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x01,0x07,0x01,0x01,0x00,0x00,0x00,0x00}},
    // /* Track ID */
    // { 0x4804,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x01,0x04,0x01,0x03,0x00,0x00,0x00,0x00}},
    // /* Track Number */
    // { 0x4B01,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x05,0x30,0x04,0x05,0x00,0x00,0x00,0x00}},
    // /* Edit Rate */
    // { 0x4B02,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x03,0x01,0x03,0x00,0x00}},
    // /* Origin */
    // { 0x4803,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x02,0x04,0x00,0x00}},
    // /* Sequence reference */
    // Sequence
    // { 0x0201,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x04,0x07,0x01,0x00,0x00,0x00,0x00,0x00}},
    // /* Data Definition UL */
    // { 0x0202,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x02,0x01,0x01,0x03,0x00,0x00}},
    // /* Duration */
    // { 0x1001,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x06,0x09,0x00,0x00}},
    // /* Structural Components reference array */
    // Source Clip
    // { 0x1201,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x03,0x01,0x04,0x00,0x00}},
    // /* Start position */
    // { 0x1101,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x03,0x01,0x00,0x00,0x00}},
    // /* SourcePackageID */
    // { 0x1102,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x03,0x02,0x00,0x00,0x00}},
    // /* SourceTrackID */
    // Timecode Component
    // { 0x1501,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x07,0x02,0x01,0x03,0x01,0x05,0x00,0x00}},
    // /* Start Time Code */
    // { 0x1502,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x04,0x04,0x01,0x01,0x02,0x06,0x00,0x00}},
    // /* Rounded Time Code Base */
    // { 0x1503,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x04,0x01,0x01,0x05,0x00,0x00,0x00}},
    // /* Drop Frame */
    // File Descriptor
    // { 0x3F01,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x06,0x01,0x01,0x04,0x06,0x0B,0x00,0x00}},
    // /* Sub Descriptors reference array */
    // { 0x3006,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x06,0x01,0x01,0x03,0x05,0x00,0x00,0x00}},
    // /* Linked Track ID */
    // { 0x3001,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x06,0x01,0x01,0x00,0x00,0x00,0x00}},
    // /* SampleRate */
    // { 0x3004,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x06,0x01,0x01,0x04,0x01,0x02,0x00,0x00}},
    // /* Essence Container */
    // Generic Picture Essence Descriptor
    // { 0x320C,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x03,0x01,0x04,0x00,0x00,0x00}},
    // /* Frame Layout */
    // { 0x320D,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x04,0x01,0x03,0x02,0x05,0x00,0x00,0x00}},
    // /* Video Line Map */
    // { 0x3203,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x05,0x02,0x02,0x00,0x00,0x00}},
    // /* Stored Width */
    // { 0x3202,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x05,0x02,0x01,0x00,0x00,0x00}},
    // /* Stored Height */
    // { 0x3209,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x05,0x01,0x0C,0x00,0x00,0x00}},
    // /* Display Width */
    // { 0x3208,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x05,0x01,0x0B,0x00,0x00,0x00}},
    // /* Display Height */
    // { 0x320E,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x01,0x01,0x01,0x00,0x00,0x00}},
    // /* Aspect Ratio */
    // { 0x3201,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x04,0x01,0x06,0x01,0x00,0x00,0x00,0x00}},
    // /* Picture Essence Coding */
    // CDCI Picture Essence Descriptor
    // { 0x3301,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x04,0x01,0x05,0x03,0x0A,0x00,0x00,0x00}},
    // /* Component Depth */
    // { 0x3302,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x01,0x04,0x01,0x05,0x01,0x05,0x00,0x00,0x00}},
    // /* Horizontal Subsampling */
    // Generic Sound Essence Descriptor
    // { 0x3D02,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x04,0x02,0x03,0x01,0x04,0x00,0x00,0x00}},
    // /* Locked/Unlocked */
    // { 0x3D03,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x02,0x03,0x01,0x01,0x01,0x00,0x00}},
    // /* Audio sampling rate */
    // { 0x3D07,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x02,0x01,0x01,0x04,0x00,0x00,0x00}},
    // /* ChannelCount */
    // { 0x3D01,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x04,0x02,0x03,0x03,0x04,0x00,0x00,0x00}},
    // /* Quantization bits */
    // { 0x3D06,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x02,0x04,0x02,0x04,0x02,0x00,0x00,0x00,0x00}},
    // /* Sound Essence Compression */
    // Index Table Segment
    // { 0x3F0B,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x05,0x30,0x04,0x06,0x00,0x00,0x00,0x00}},
    // /* Index Edit Rate */
    // { 0x3F0C,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x07,0x02,0x01,0x03,0x01,0x0A,0x00,0x00}},
    // /* Index Start Position */
    // { 0x3F0D,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x07,0x02,0x02,0x01,0x01,0x02,0x00,0x00}},
    // /* Index Duration */
    // { 0x3F05,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x04,0x06,0x02,0x01,0x00,0x00,0x00,0x00}},
    // /* Edit Unit Byte Count */
    // { 0x3F06,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x01,0x03,0x04,0x05,0x00,0x00,0x00,0x00}},
    // /* IndexSID */
    // { 0x3F08,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x04,0x04,0x04,0x04,0x01,0x01,0x00,0x00,0x00}},
    // /* Slice Count */
    // { 0x3F09,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x04,0x04,0x01,0x06,0x00,0x00,0x00}},
    // /* Delta Entry Array */
    // { 0x3F0A,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x04,0x04,0x02,0x05,0x00,0x00,0x00}},
    // /* Index Entry Array */
    // MPEG video Descriptor
    // { 0x8000,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x01,0x06,0x02,0x01,0x0B,0x00,0x00}},
    // /* BitRate */
    // { 0x8007,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x01,0x06,0x02,0x01,0x0A,0x00,0x00}},
    // /* ProfileAndLevel */
    // Wave Audio Essence Descriptor
    // { 0x3D09,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x02,0x03,0x03,0x05,0x00,0x00,0x00}},
    // /* Average Bytes Per Second */
    // { 0x3D0A,
    // {0x06,0x0E,0x2B,0x34,0x01,0x01,0x01,0x05,0x04,0x02,0x03,0x02,0x01,0x00,0x00,0x00}},
    // /* Block Align */
    // };
}