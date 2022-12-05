package com.adventofcode.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(input);
        List<String> duplicates = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            final int mid = line.length() / 2; //get the middle of the String
            String[] parts = {line.substring(0, mid), line.substring(mid)};
            System.out.println(parts[0] + " - " + parts[1]);
            duplicates.add(findDuplicateLetter(parts[0], parts[1]));
        }
        System.out.println(duplicates);

        List<Integer> values = calculateValues(duplicates);

        System.out.println(values);
        System.out.println(values.stream()
            .reduce(0, Integer::sum));
    }

    private static List<Integer> calculateValues(List<String> duplicates) {
        int aValue = (int) 'a';
        int zValue = (int) 'z';
        int AValue = (int) 'A';
        return duplicates.stream().map(letter -> {
            int asciiValue = (int) letter.charAt(0);
            if (asciiValue >= aValue && asciiValue <= zValue) {
                asciiValue = asciiValue - aValue + 1;
            } else {
                asciiValue = asciiValue - AValue + 27;
            }
            return Integer.valueOf(asciiValue);
        }).toList();
    }

    private static String findDuplicateLetter(String part1, String part2) {
        for (int i = 0; i < part1.length(); i++) {
            if (part2.contains(part1.charAt(i) + "")) {
                return part1.charAt(i) + "";
            }
        }
        return null;
    }

    static String inputDemo = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw""";

    static String input = """
        WVHGHwddqSsNjsjwqVvdwZRCbcJcZTCcsZbLcJJsCZ
        hngprFFhFDFhrDpzzQDhtnBJJRJZbZvTcvbfRCJfBRcBJl
        DmptngtFwvvMmwmm
        HFddrJnLdqtHBMQBmmVm
        gbvNsbhsvQtmZTbQPT
        vDshDlczcDhcssscwzQwslLJrSJLpqrrzpnCrSfLSnqq
        pDGQDSpFDGzFDQSJqzDhjhQMTjTrwTstbTBTjTtLtbTMBT
        zgzVNHHgMwMLbLNB
        WRWPgdHCZccggJmJGzJmzGhGCD
        sVJNlhldShpdpnnwVnwCwtwggt
        WLFFcHWQLPPZQCgtnCgmbtbHwt
        MPLWzRMMcGgRrWNDpSSSfDflMlTd
        BBMZJcgBRjCZZzBpSvHQvbLvvHCQLQ
        VlVTFwDTVGnfWSQPtsDPbvrpDS
        wWdqhWlwGVfGwlfTVqFWfWWjzZZBJmMZMNdzZJMpjzNjgJ
        FBWFphQBmDmpmMSpDWVcVcvsPcRbrjPMcMsr
        HHtdnHnwNCHCTJRTPTzrbvVbcVRr
        lHqHwlnlqnGCNGGmWDvvZfpZvG
        mfVtmPtsccMmHcHCFfmhVmnpgZLbWPZqWnpqZbZWpgPW
        zzvwBrzdQDvpZJfQJZJpLf
        BrTBwRdNcfNmfStc
        sTlhFLfZTTLcfsLlLDZflvQvRNqRJFNvRMRNvQQRBQ
        CWcgwStWwCWWwvgNQvJBvQMQRB
        wptGzbzGWVGSCVVlVlLDcVVsfhLTlf
        HVnMVGwLLbsGnVsLnwLSBggMhjmgmgmhtmqhtgMhMj
        zrZzJRZfzZfrPCrFcWccPdTdHHlvdmlgTghCtmtTgq
        NFfcZWWzZrrHLBpBBGVGNG
        HqFhhCBCBLmwwCqJCHFvvFdcprrrSSrjRFRjpgrggb
        VGzWtQzGGQPVtlVNslVWsPdRpmcRrjpSzcrcbdSmSnSg
        WPPGllQMPGmTLvLJBCwM
        PvDWRSmTVvSvRhbZRpRpbjjjzM
        GBFGHLglHrrrLgGrttbMjpbcpcZJBsBp
        lrHgrrndgdNnlHGFQPMMmWPTvvWSCDQn
        mmhQShhmhQfzNfTTlShbHJrRtltltJJtHlRLLZ
        WscggNqwPWjcGcWWcpNcRJHHprZvZHrvtttZJpJr
        jGjgcMGCwPNsGDCcszBfhhQQQDnFnTVVBV
        mcGjrwzQcrZtQzZQDZcPssvPVVCPCVLwswwPBC
        NJbqHddNSgdPWvvsVHVLPs
        NqglNSlJFNSbSNdldNlNdNbTRFDrvRmQrQGtmDrvttQmmtDj
        zzcBPnHBjgHjWJvbJQTvScbwcQ
        qdspVCFqVqfFqLFCqtpTwtpTbSTbJpwBST
        FRLFRCNNqMfdWNmZPBPZrHmm
        VmtRRJmtrDrwhRcvPspltvgqtqsd
        WGQBZzMMBGBGbZTTWWCMNSgggqnPlsfbqndndccglffg
        CWQQZMFWdzMQdJJwJVFrwmmmRw
        rZsFfGfNhznzsjhzZfVjGVvVdvSTSJHSDDtcmmmttC
        wWpRBWlbWMWlQDvCcRSvJRSStm
        LPlwWqbgwqjjcFshNf
        lsppsGphmPrRQnvHdRpd
        qBgjLqMjgjTLPnzHPrPRLnzv
        gSMfNjNtttVbqBbtTSStjTqlhmlZDsDsbWZWFFFsGhlWPm
        sPDPDzrGzBsGRsbwrjtSVvthVfQtQw
        ClpgFZgNqMWCgqCpMNZqNWmNdtSwtljtVHQhtwfvdHtSdhSj
        FpNCJpNcpfCpgNWPGBLcbTGTzTzPnG
        mssNLCZqSqmNCHmrqHChJTjTjnRRnnqVnTTGngGTRn
        dbwptFwQbvdtcvpZDcDddgzGPjTGgpPTRpzzzgRzTn
        BwZdtZldDbrSsNrsrSHl
        MLnFWMRWpnpnLnLCmPGTqQsFzBttTQ
        SwNlDHNcddglSDBjrqmqGQqqmGtGGwszPP
        vdSlNcrvvvnBMbBR
        psZPRmTpRpgrlrDRBFgV
        jvCqNhwnjhGNqCMqVgFHWtgHBrtwHFrJ
        cGvbNcjvvhhjcvbQGcZdZSQpzdpmpPVpdZpd
        drTHDdlHzllZDTzTQRQLsPPSsBbSjQdL
        MfVVWmNvMnqNmVVpMMgfgMmvBFFfRRLQPPsPfsFLFCFRSFjR
        whMnNVnqWmlllHswJTZT
        ZSQTTLLlTsbmmDZlmNQSNFfPwHwqCjCCfjwFPwfwLr
        MctMJMBVttnhJcBBVctwRHjHRJwJwjFfqPfRwj
        vzqgqhBVzzTlZmmTlN
        WgvlHJFvljvdBmzcvcwpmchc
        TQqZsTZttLZbRZsLLMzzppBmNShCmBNTcNCN
        LPMZsMZLMQVgglFPhFHlFl
        qsBCPVPqVbwfnMQNmZJnqJgR
        hHdrvvLWtvtjWQnZJTMrmpTZgN
        DShSShLZdFGPGDPGsPsG
        qRBddRzFFqFqHnNnPSnnmmSpgpJm
        ssZDQMvvMwppNJWRDRpW
        MMvwlsRMcQBjcLqLBBqc
        ZGHpwFGvwpHrvfFTMtDfccMjntMntc
        RgSCLRLJRSRSQQqJmTDMPMTtsJjnclBjtj
        LVmmSSddLCwVHDbzDzZr
        psgWdsBjnnJjbZWQDDLNrDcrLVQjLM
        zPSCCHqCfqfmWNMcrVSLRM
        TPHzWPFTGztqTGgdJdsssvZgwb
        gcFgBChcClJjNCPb
        sWZdZdrSmWmSZRwSmsvPlsTtTtNMnnlvnJJv
        GSWrHZdGQpRrrSGmpWQmQfLfpVzDfghppzBVLBlBqg
        BFNqFzBNhqVwmTtsqVst
        dMwMwMfCMWbDtDvDssCC
        ldMwMSHHMMWJpRpPLLpBzPZjgnZPhN
        WczRJhcWggVBdzPPLnCjdvjm
        lSpSTpTSsCCmmntNdp
        wSFDCTwsGDqQqQVWWcJw
        RqPqhDGBhRDrrhBFmPmbgssZbwbgCbwsmZsQ
        nCtjMppjfTpjJJfVZwtzZtllLZwLss
        MHfpMWdHpSCSfnSTJWhDDFDFBGqDGvvDBDFd
        MCCGMCSHVGNTspVWQznddndg
        rttLtvRbrhLZrbcQdJnnQdfddsrggf
        BbRqltRtHsNNllNC
        ncFpcsLLdFmWlRmnllTR
        bMMVzVqMzjNVDblmRTPGlSmmPlqG
        gNDDJMVZNCbNJNDNQCbZCbscvBsdBvrRHfcpdQpfFFff
        VnWFbZvFbHWhFjZWVJZJLZFWTttpMCspQTTzQCHpgQMgztzT
        dGcfdNdGrlRlBDGNSllfBMspgzmTgtQQgztMtzpmcT
        lBNdqRsBRdfPNrLPFVVPVJPZZvhj
        TLWgggJzwjgWgjgGnnmQnzQfNNNQsm
        SpPbBlPBMlvFZpbbBmQGsmCJmCstsdNGBQ
        MhSHhZPrPbvSFrJPpPMSbMcLjjqTLHDRTDDTTLDLTqgH
        fprRRbbznFbcQVPDdQPdFV
        LTvmsLmcsHmvDvSZDZVVSS
        jWtmLccssJTLjHmLWWJwnwlBfwnBbllpCBnffbBr
        plPBWzbnFLPPtGqMMwlMGwmS
        ZQjDHjrQjdjVFwdMvCSfmwMqdt
        DDhhrRDjQghHJjhWBbgbTccbsTzpWF
        vgCbbwsTbWWWgwBWDGGDqtPGtMgGlFMH
        znrznJNhLSLphRRRDlFPMmpFPjjHtMFF
        llNcSQVSNcRbvCwwWcTdwZ
        qpnJbnRRnJhRFhFHRgQSzHlSRHCCCg
        fMBttBvsBjffvsQTtfGTWlCWsSgSmHCzZmLlHgzZ
        ffMdjrfdwjfwwnhJPFchhqwQ
        NCVSTCVCQCCRVDQSJsqFPsPNspFhhsgjPh
        btvtWtcWnpgmFhjmmt
        cfnffBfcWcrMdbvMQJDDrDTDVCpCDrGD
        fZNhBWFSlFQFjWQTTldHgCwvTvqqdr
        zznVzCznmHvnwgdH
        PMMbCGPMDPcLbJhFhWhBhRScQZBQ
        WQMrDWGHbSWHMNrTQRhghmgPZccmqDLwPqPg
        svCzfpdzzdsnslCsnPZcHZPlJcqZgmqPPc
        nntVpdpVsfjCHzvnsCzRTBrtWGbNNQSMbTNSRr
        SnpDQdBqGpDSBMfQGcMQBDJPNstvJcWNsPJCtJtNRWPC
        VrVHrhTHlPHTvvNtbhNRNswC
        TzlFHHmrVlgTlTGSzGqpdMGBPQBS
        zrCDnrDVCnCgnrHgGDnVVCZsNttQZmjtsmbMqGqsjbqj
        TlRRWPSwwFwbSwTTTpNQQqNjqZZlmMMQQt
        wvbwbRTLWdFFwvRBTbvTTRzrnznnJrDDCzBczBfHCJnz
        SvTdmLNNNdvTBmvmLvSvDpgczzjfgjggpcjcNPzD
        VJHQsJVlHpjjpzsjzP
        VRlJbJQrVbVHJJPMhBdnBRCSLZZZnvnLvv
        tMGcpGtMtLtsCGspLzNCBBmwCzQRzBBRWQ
        hdlHFllDdZgDbDDlDHTWWTnzBBBvzmNHzwRz
        FSddDlFRqDFqFSdPVqdhcfGMsVtVfLjrfGfjtMcs
        RGMWnBMWfCCMBHTDptJJgZStRPmSRD
        bqzFqjqcFLNLZZSmpSBgZZ
        rFrQNbNBlNcbrQlNQvvclMswTCTCnwrwHrWGsGCswn
        WLhJQddCQwRNCQNHczHNzMvZcZvcNc
        SlSpSlrpDqnbqDjlGjGGljTjMZZPPMMfVPgfHMMVgVvqfgcw
        SbGsDspbbnjTjBldCFmLwFCJLBmtJB
        TMDjMvMqMvDTzcmFCgrJCr
        ZZZJSZWVBHZWSSZQJhVhWnHJwczGGwGcCCFzwgmzcwFgwVzc
        pLHNQSnNJsMLRJds
        TsLZGwdsDFWHBZJFfZ
        mqhRvqrzJRbmzJBFfgHHgWgHrrlH
        JvvNhJmvtDdsNTwdLV
        wwnSVSmwtbstznwgbzzVMTNpTNWdlCSlSWTffWNCSN
        cFvccLGFGvvGHZflnNTpnZpZcB
        GPqGDhGGqrDhVRgbnbttPmgs
        rzSZJScLrcBLvjvsqMPZvjQl
        nnpDqgDqFTgwqHHvMHvvvTvPMM
        GnqCGpDqqVhccLmrmSmCRL
        tJSTmdfddDTDJCPmbQvQLHvqqqbrbvlP
        zWGsjcwwGGcVVjcGWcNjvNjQqrQtNFFQHHrF
        RZnRVsswRsGWcwVBZVtBRdDJgCffTgmgfnnCpfTfTM
        FnCrzhTrNPrMcnhMTnZZZNPwDPdbDmdDtwjdtjbmQwDt
        sBvWrpppvLBsLRVBfHSfbbQmbwSjStDSwSwS
        LVRRRJqqlHNlNTChrhMG
        WNsfsstMvtMvNNGPZwmZmqZPLWZcww
        rDCdDRCDFQjSVLcmZcDq
        bBBHqTgBbQlQRCQFbgqdhvshGvTJMnfTtnnThnsN
        VwWBTNQcVzDtrgfrtzzt
        LLbpShLGvlbCmLjpGSCSCpvFdrgdddcHtrtGgfqHcDHqrd
        pmvLmlpmjbLbpljJPBBcTBBQRZBBVJRZ
        cVTcVTNvvghNhvggPPgtCVSpSQmzCqZDRCmDZDZS
        dGJMWFsFMFWsnlzRlQzlzqpzlZzD
        HdLFssFMsJbnbFjqbhPgjNggcrhg
        LLVhQCTvRvmWlCppQfQQjPrwszNsfzNz
        BZSgncHgnJStJHJgntMWzGsrPqGwsfPfGPwwwZ
        bdBdJMBcShWCLbhWVC
        vjdpGNGwSNCTwwRbfnWgQMLjQWMnLQ
        DcmFPFtHmlcgpqWDnMbDLf
        FZJPtcprHtPPHplZHPZclwwGBSZSvSwCwvZzNdwvvw
        CdJLJCJPWPWcbtzJtqJzFrQvBhfjBBvjjvdjpFjr
        sBRgsZGDNSBBRGDwphrrrThpHpgHvhpQ
        DwDsGBDNwGmMNlMlMDSPmztJVCbVCCWqPqJLmW
        LSTMgDSRSMHbMDWLHSvDScwtCGqGrjGrcLftqVGtVC
        hzJPmlphCGrCwVrJ
        zhPNdNnQZBZBhZnNZSgMWMDbMHwWSDWNDH
        rcdvvcwvrHrMZBjHSZ
        sDtWblgnltsDFlgFqltCCVQTMTgSHVTfSQfSHj
        tDtRWFpFbWWWWNNDWsNqWvmzvhzhzGmzjjGvLwJmpc
        nFSSnnbhSfgLSSnVjdjfHMgfMzGzmqlNGGmTPlqqTzTNNzlT
        pBZsJJvccbBmlWGlNb
        cvsssvZwsDwrDdfFgnbDfVbgng
        mWRNWNCTdwdCwhCddbWWmhsZVgJQJBVBfsBsJQLQBLJb
        qFFlGzFtjjcqzHtFtlRfVfsZfQHVfBHQRHgf
        jqGjtcDnGnPzFRlzrnMdWrrCMMddNNWT
        MHWCjjGMcHhbhPDLphHQ
        nRVJrtgssdLgCppvLQbg
        RlVVZNVRJlsstldsBCNlczfjjSZmWTcmGmTSfmSm
        RTHqgTgMwgnGTRzqTHCGfdFdfhmBrJrdvbFJMhPB
        lNZNNNLttLWJBPBdZBFmdZ
        SppscpLVStclNPWtCczqnQQwHTTgCGwq
        hSHRCbZRSZhbRZBctnMVjwwtWtwh
        GrdFzQrDdJstjcWttwsF
        drPJLDPGPvDvzrJPQLdDHpZlwLgRmwCHLpwgSbff
        zMSSnCtCdSdCtdfMdHMdtVBDjhWDHBqbTVVBqhbDjr
        cPNhFFNRlNDlTBqjlTBG
        RvmvRpPNRgwgPvFwhmdCssmCzdMshMmL
        tttjgrpTwmCgCwgwrrlrHzbzqqFNzdJqqZnddJwNbh
        cQjMjPMBfcLBSjGQBndFnzNdNnhzzNGFbF
        sSQPLMfVPBVSfBMvVLSPfHCttDjCDRRtrVVglgpttD
        vdTvdpBvcTPdSSvCLrCCDLDCQGDl
        sRfnFgmFRMVsnqgRmqzmrrDBDwtHlLHtrLCDGL
        qRMVjJgRFnJfMssMsgZScPJpZbPbPPWhBZSp
        ZJgNJhGZglMZZFDTPSNqFSqTSb
        mwdvwpsjrcjBvpwFrvbHcDqbWHRWDSPWDHSR
        CsvpsLLjFzhlLGFZ
        sDNQrMrNfrlQjJRgGjbTllHG
        ZRhSnWFVSwBtFRBVvVgHgbzjgGTJnngmGmHC
        vWZLShhvZLVtSFSLqwVrQdqpcqMDddRNQMdsNP
        hQhSQbbwtHzShwhSQPbJRsLwRCjJmDCcvmqCcs
        FNdBTBTNMsRqqCjTjL
        GNdrdMBVFShhSLSGGL
        cZzcCmjjcvdzdWqgWTZgPZgZhh
        wSwVGSJFTffgJTNh
        FSVpVlBMShzbjzcpvp
        qqlblClRbnTvqTmRqlmnTwrdfdwFFNrngfddDBrNtr
        PcLcQLMVLGMzHLMchhLcjLFrrNrBfrfFNJtNgJDDBNzt
        sSjjGcGQscSVSMjHVMSVPSQsWmCmppZCmtCWbbWTlZTqTl
        qWlVJmDJHWJHVJlsdVTdhbFNNgFhwhhhFhwwZg
        npjnvQpStCQLvBpPnvtBtBpGSGbzbGDggGNbgwghzZNGGN
        jBvLtvjnrtMDmmDRTTrsWc
        pmwdwzJtFmmlpFsWwtstJPGgvNgCCLWCvPgNNPQCQv
        RfbfTRBnRGQvPNnncc
        ZTbPZSDSBfSBVSbbBRbbbtrFdtlFmVsswtFwzdpszw
        hVphQcmdcWWprWWhChFQBsfHjDTTBCHlSsTSBgSH
        vqBRqqzbqMZPMwSTDjJjlHDllgHZ
        PMnMLqtMnntQhWBccthB
        vqqvCSvHSSwqvqCddnvQFmNbVjbJVVmGNNVHNNlH
        pggrhzWgptWhZsmVlFmgNNVNbj
        RzpMLLhhphtzrRrSSbQTBQwSTDBwQM
        DSFQDlDFRddDHQHQtFlDVsVMTzrMCLSWZLZffSzLWrfCJz
        jjBBvpgmbppBPbMwBBBNbbZWZzzCCTzzZgzWcJccLzWz
        bvPwNwmpnBNhPmqpPvnwwNmtRQGQMdQDQlsGVVGhRlGFsl
        SfJJwDJgpGdSGJNSTwTVJDRbWWfLtCWCLtRLHWrtbWBf
        cQQPnFhjjQlczhqllhszhqsQRWnrbrHdHtbWrBWBbtvvHBrW
        qMqqqqzFFmPjmmsFjmzsmhjcDGSZTJgTdpZwZgwSZVpMTNVG
        czrcHMcMJtCCPnpFmH
        DwGGlvLljGmDRdwLdLjfhtFsssnFVpfttpptsnFPnp
        TlRTghTjwTDRTDlZZQgWMMrMJMSZmM
        BzdNzNdgNNPfgdNsdQdNvVMLLVQVMcCRCMRmvCGc
        zHpplwwZrZlqlWWrpZwqlHhLvqMCRDCGVmLcqGMVvCMmMD
        rWrjwWwHplZbwpZtHtJJbgfFTfsNnBbsfbSdTzgB
        jPRRppDLDGDTLLggMMjpLTGcrJWHsttJfwnWrMvrJnvnrNfJ
        blqbzBdzmhhbQWnsNHtJvfssfd
        lhFhzSzzSZVNSlVPgDPCPCGTRcGR
        cqWcNWffPftvsvfpqPtZsBzrbmbFddBmbcLbdDHbHz
        TJgljTnGgnLBTZbHdBFz
        JgSnJwSlgGJRwMtfPtvfwsZQZZtv
        hHhPbQPTwsdwdHqtgttjpNfjDt
        FFlCmSzRCCmlzzRGCFNvRpvjvtZNZqsRfNRg
        mVmsFMGFzJFBwQTMnMQndd
        QQVpQGcVdGmspHHLtbqfqfbt
        JvZTFDFzJzhFCWCZZDzWPBCJfLbnnwLqttnsHHNPwtbHLwjn
        DssTMWvvvGMcQGQGld
        sshRHZSZRbSZHhBFBMpMWpFgbbtb
        JfjTjmwwTPvfTNPTQlmFFFqqmFMBBqFgFt
        vDTvJffQTJjJvPvTNSHRzhCsShRRRDtZHz
        NFLsRDNNDNBDlgPPgBglQlzj
        HJhdZpfJzlWQjjHw
        ffJTppZZqTNlGnNsMG
        ZMrWcWwqqvPZMndGdqlnnDLnVT
        HpCsshCfpFfHHJDDSlSVQQGGflDQ
        zssNzRJFhjNHNNHpJRwbwMMzWWtZPcbBbwbG
        HlNHHLHsBDRpHLlsHRlJnMhfWZMRnvCCCnWhZj
        wtqSmQqttzSSQdPmmwZhChJjWJjPggCZCfZJ
        SSwtTbTQmbtdqmGTTcfqzDLHFsBLDGLNGrsBHFGrLB
        FFDvWznMWWMrPnPnWPgsmgQbhJRslHbwHwVVsVHjBsHb
        ZtSffffpdLqpSCLfCNqfLqLCjHjHbwhpBwJllHlRVQllphjj
        ZcNCtcGSctZScqfNGScLNcczPJFmzmDzGzWnrWFPFWDvrM
        DnTPspmTPsTCDQWRZzZzZRCRfCfHfh
        BNcqTBcFgbVchVJhVR
        dTwdrBrwTSPPWnnmSmsn
        pfbbDbHpNBFmQbpNNBSlLtlDStSdSPJLtLJR
        ZcszvwgVCZswFzVTRTlTlRLgRJSWJR
        jzZvVwFjcjjnwvzwZcjMpqMpbGQbQmhhHhmfHQmh
        hTbddhQCtdNmdtwtdhTBbCddRSWscczwcRSWLJzcFJzDsFsR
        NflgfPZPcgSLJcWD
        lPVNZMMMpZlZZvfrMvpbQHQhtbtqdTQHthrqhd
        JlWSStwhWJSRJpJvJBjTwTqcwTsDjsCTCB
        dqFzgFZGGQNVmTcCrjrzsBrB
        fdgLFQLnPdnqShRMPhlJMpWW
        TMPcsPDjdDhsDcDcTTTDvdvghBNFGGtmNrSrgSSBGNtNFg
        CVCbJqlRVVWWpRqRQZRWVWJZBtmSFGNmggGmtmmBFbrGMGMt
        JRqHVJVCRLZWTjMnfLTPcfLd
        TRTZFTTrghrZVhVWdWZpMmbzbdzBmtDpDDzmzB
        wcsSSsjfPfGPqQwqsQcfJJCtJGpppCBJzCbzJzCb
        sPjflcwljfjfvqNcTZTRhtVWrNrVLnrR
        rVLLsmwmCWTmsCTdwQrdTmqWDjDHjNGNPbjDBPNDNsZRDBjH
        cFcSvgJvfhfLnShtMJtPHRRvRbBBGBPNBHPbND
        hgLcgcLpJSMwzmrmzqQrmp""";
}
